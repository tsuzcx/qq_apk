package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import hyx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForGrayTips
  extends ChatMessage
{
  private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
  private static final String TAG = MessageForGrayTips.class.getSimpleName();
  
  public static String getOrginMsg(String paramString)
  {
    int i = paramString.indexOf("                    ##**##");
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int j = 1;
    if (paramInt1 >= paramInt2) {
      return;
    }
    String str1;
    Object localObject2;
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("new_item_tag", true);
      this.extStr = ((JSONObject)localObject1).toString();
      if (paramBundle == null)
      {
        i = -1;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addHightlightItem ==>actionType:" + i);
          }
          str1 = "," + i + "," + paramInt1 + "," + paramInt2;
          localObject1 = str1;
          switch (i)
          {
          case 4: 
            paramInt1 = this.msg.indexOf("                    ##**##");
            if (paramInt1 == -1)
            {
              this.msg = (this.msg + "                    ##**##" + "1" + (String)localObject1);
              return;
            }
            break;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "addHightlightItem JSONException");
          continue;
          i = paramBundle.getInt("key_action");
        }
      }
      localObject2 = paramBundle.getString("troop_mem_uin");
      if (!paramBundle.getBoolean("need_update_nick")) {}
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      localObject2 = str1 + "," + paramInt1 + "," + (String)localObject2;
      break;
      localObject2 = paramBundle.getString("key_action_DATA");
      paramBundle = paramBundle.getString("key_a_action_DATA");
      localObject2 = str1 + "," + (String)localObject2 + "," + paramBundle;
      break;
      paramBundle = this.msg.substring(0, paramInt1);
      String str2 = this.msg.substring(paramInt1 + "                    ##**##".length(), this.msg.length());
      paramInt1 = str2.indexOf(',');
      str1 = str2.substring(0, paramInt1);
      str2 = str2.substring(paramInt1, str2.length());
      paramInt1 = Integer.parseInt(str1);
      localObject2 = paramInt1 + 1 + str2 + (String)localObject2;
      this.msg = (paramBundle + "                    ##**##" + (String)localObject2);
      return;
      localObject2 = str1;
      break;
    }
  }
  
  protected void doParse() {}
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    int i;
    String str2;
    Object localObject2;
    Object localObject1;
    int i2;
    ArrayList localArrayList;
    int m;
    try
    {
      if (this.extStr != null) {
        bool = new JSONObject(this.extStr).getBoolean("new_item_tag");
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getHightlightMsgText==> isNewHighlitItem:" + bool);
      }
      if (TextUtils.isEmpty(this.msg)) {
        this.msg = "";
      }
      String str1 = this.msg;
      i = str1.indexOf("                    ##**##");
      if (i == -1) {
        return new SpannableStringBuilder(str1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "getHightlightMsgText JSONException");
        }
        bool = false;
      }
      str2 = this.msg.substring(0, i);
      localObject2 = this.msg.substring("                    ##**##".length() + i, this.msg.length());
      i = ((String)localObject2).indexOf(',');
      localObject1 = ((String)localObject2).substring(0, i);
      localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
      i2 = Integer.parseInt((String)localObject1);
      new LinkedList();
      localArrayList = new ArrayList(i2);
      m = 0;
    }
    int n;
    int j;
    int k;
    label247:
    Object localObject5;
    Object localObject4;
    label380:
    int i1;
    label478:
    long l2;
    long l1;
    if (m < i2)
    {
      n = -1;
      j = 0;
      i = 0;
      if (bool)
      {
        k = 0;
        localObject5 = null;
        localObject1 = localObject2;
        if (bool)
        {
          i = ((String)localObject2).indexOf(',');
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
          n = Integer.parseInt((String)localObject1);
          i = ((String)localObject2).indexOf(',');
          localObject4 = ((String)localObject2).substring(0, i);
          localObject1 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
          j = Integer.parseInt((String)localObject4);
          i = ((String)localObject1).indexOf(',');
          if (i == -1) {
            break label544;
          }
          localObject2 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i = Integer.parseInt((String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getHightlightMsgText==> actionType:" + n);
        }
        switch (n)
        {
        case 0: 
        default: 
          if (bool)
          {
            localObject4 = null;
            localObject2 = "";
            i1 = j;
            j = i;
            i = i1;
            l2 = 0L;
            l1 = l2;
            if (localObject2 == "") {
              break;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong((String)localObject2);
        localArrayList.add(new hyx(i, j, l1, k, n, (String)localObject4, (String)localObject5));
        m += 1;
        localObject2 = localObject1;
        break;
        k = 1;
        break label247;
        label544:
        i = Integer.parseInt((String)localObject1);
        break label380;
        localObject4 = null;
        localObject2 = "";
        i1 = i;
        i = j;
        j = i1;
        break label478;
        k = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, k);
        localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
        i1 = Integer.parseInt((String)localObject2);
        k = ((String)localObject1).indexOf(',');
        if (k != -1)
        {
          localObject2 = ((String)localObject1).substring(0, k);
          localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          localObject4 = null;
          k = i;
          i = j;
          j = k;
          k = i1;
          break label478;
        }
        localObject4 = null;
        localObject2 = localObject1;
        k = i;
        i = j;
        j = k;
        k = i1;
        break label478;
        i1 = ((String)localObject1).indexOf(',');
        if (i1 == -1) {
          break label1514;
        }
        localObject2 = ((String)localObject1).substring(0, i1);
        localObject4 = ((String)localObject1).substring(i1 + 1, ((String)localObject1).length());
        localObject1 = localObject2;
        localObject2 = localObject4;
        i1 = ((String)localObject2).indexOf(',');
        if (i1 != -1)
        {
          localObject5 = ((String)localObject2).substring(0, i1);
          localObject2 = ((String)localObject2).substring(i1 + 1, ((String)localObject2).length());
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = "";
          i1 = i;
          i = j;
          j = i1;
          break label478;
        }
        localObject5 = localObject2;
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = "";
        i1 = i;
        i = j;
        j = i1;
        break label478;
        i = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, i);
        localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
        i = Integer.parseInt((String)localObject2);
        j = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, j);
        localObject1 = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
        j = Integer.parseInt((String)localObject2);
        k = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, k);
        localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
        k = Integer.parseInt((String)localObject2);
        i1 = ((String)localObject1).indexOf(',');
        if (i1 != -1)
        {
          localObject2 = ((String)localObject1).substring(0, i1);
          localObject1 = ((String)localObject1).substring(i1 + 1, ((String)localObject1).length());
          localObject4 = null;
          break label478;
        }
        localObject4 = null;
        localObject2 = localObject1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "getHightlightMsgText ==>NumberFormatException");
        l1 = l2;
        continue;
      }
      i = 0;
      while (i < localArrayList.size() - 1)
      {
        j = i + 1;
        while (j < localArrayList.size())
        {
          if (((hyx)localArrayList.get(i)).jdField_a_of_type_Int > ((hyx)localArrayList.get(j)).jdField_a_of_type_Int)
          {
            localObject1 = (hyx)localArrayList.get(i);
            localArrayList.add(i, localArrayList.get(j));
            localArrayList.add(j, localObject1);
          }
          j += 1;
        }
        i += 1;
      }
      localObject5 = (FriendsManagerImp)paramQQAppInterface.getManager(8);
      Iterator localIterator = localArrayList.iterator();
      localObject1 = str2;
      Object localObject3 = "";
      i = 0;
      if (localIterator.hasNext())
      {
        localObject4 = (hyx)localIterator.next();
        str2 = (String)localObject3 + ((String)localObject1).substring(0, ((hyx)localObject4).jdField_a_of_type_Int - i);
        String str3 = ((String)localObject1).substring(((hyx)localObject4).jdField_a_of_type_Int - i, ((hyx)localObject4).b - i);
        localObject3 = ((String)localObject1).substring(((hyx)localObject4).b - i, ((String)localObject1).length());
        i = ((hyx)localObject4).b;
        ((hyx)localObject4).jdField_a_of_type_Int = str2.length();
        if (((hyx)localObject4).jdField_a_of_type_Boolean) {}
        for (localObject1 = str2 + ((FriendsManagerImp)localObject5).a(this.frienduin, new StringBuilder().append("").append(((hyx)localObject4).jdField_a_of_type_Long).toString());; localObject1 = str2 + str3)
        {
          ((hyx)localObject4).b = ((String)localObject1).length();
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
        }
      }
      localObject1 = new SpannableStringBuilder((String)localObject3 + (String)localObject1);
      i = paramContext.getResources().getColor(2131427448);
      localObject3 = localArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (hyx)((Iterator)localObject3).next();
        if (localObject4 != null) {
          ((SpannableStringBuilder)localObject1).setSpan(new MessageForGrayTips.HightlightClickableSpan(this, paramQQAppInterface, i, paramContext, (hyx)localObject4), ((hyx)localObject4).jdField_a_of_type_Int, ((hyx)localObject4).b, 33);
        }
      }
      return localObject1;
      label1514:
      localObject3 = localObject1;
      localObject1 = null;
    }
  }
  
  public SpannableStringBuilder getHightlightMsgText4Float(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    try
    {
      if (this.extStr != null) {
        bool = new JSONObject(this.extStr).getBoolean("new_item_tag");
      }
      if (TextUtils.isEmpty(this.msg)) {
        this.msg = "";
      }
      String str1 = this.msg;
      i = str1.indexOf("                    ##**##");
      if (i == -1) {
        return new SpannableStringBuilder(str1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "getHightlightMsgText JSONException");
        }
        bool = false;
      }
      String str2 = this.msg.substring(0, i);
      Object localObject2 = this.msg.substring("                    ##**##".length() + i, this.msg.length());
      int i = ((String)localObject2).indexOf(',');
      Object localObject1 = ((String)localObject2).substring(0, i);
      localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
      int i2 = Integer.parseInt((String)localObject1);
      ArrayList localArrayList = new ArrayList(i2);
      int m = 0;
      int j;
      label206:
      String str3;
      for (;;)
      {
        if (m < i2)
        {
          int n = -1;
          j = 0;
          i = 0;
          int k;
          label342:
          int i1;
          label410:
          long l2;
          long l1;
          if (bool)
          {
            k = 0;
            localObject4 = null;
            localObject5 = null;
            localObject1 = localObject2;
            if (bool)
            {
              i = ((String)localObject2).indexOf(',');
              localObject1 = ((String)localObject2).substring(0, i);
              localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
              n = Integer.parseInt((String)localObject1);
              i = ((String)localObject2).indexOf(',');
              str3 = ((String)localObject2).substring(0, i);
              localObject1 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
              j = Integer.parseInt(str3);
              i = ((String)localObject1).indexOf(',');
              if (i == -1) {
                break label476;
              }
              localObject2 = ((String)localObject1).substring(0, i);
              localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
              i = Integer.parseInt((String)localObject2);
            }
            switch (n)
            {
            case 0: 
            default: 
              if (bool)
              {
                localObject2 = "";
                localObject4 = null;
                i1 = j;
                j = i;
                i = i1;
                l2 = 0L;
                l1 = l2;
                if (localObject2 == "") {
                  break;
                }
              }
              break;
            }
          }
          try
          {
            l1 = Long.parseLong((String)localObject2);
            localArrayList.add(new hyx(i, j, l1, k, n, (String)localObject4, (String)localObject5));
            m += 1;
            localObject2 = localObject1;
            continue;
            k = 1;
            break label206;
            label476:
            i = Integer.parseInt((String)localObject1);
            break label342;
            i1 = i;
            localObject2 = "";
            localObject4 = null;
            i = j;
            j = i1;
            break label410;
            k = ((String)localObject1).indexOf(',');
            localObject2 = ((String)localObject1).substring(0, k);
            localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
            i1 = Integer.parseInt((String)localObject2);
            k = ((String)localObject1).indexOf(',');
            if (k != -1)
            {
              localObject2 = ((String)localObject1).substring(0, k);
              localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
              k = i;
              localObject4 = null;
              i = j;
              j = k;
              k = i1;
              break label410;
            }
            localObject2 = localObject1;
            k = i;
            localObject4 = null;
            i = j;
            j = k;
            k = i1;
            break label410;
            i1 = ((String)localObject1).indexOf(',');
            localObject2 = localObject4;
            localObject4 = localObject1;
            if (i1 != -1)
            {
              localObject2 = ((String)localObject1).substring(0, i1);
              localObject4 = ((String)localObject1).substring(i1 + 1, ((String)localObject1).length());
            }
            i1 = ((String)localObject4).indexOf(',');
            if (i1 != -1)
            {
              localObject5 = ((String)localObject4).substring(0, i1);
              localObject1 = ((String)localObject4).substring(i1 + 1, ((String)localObject4).length());
              i1 = i;
              str3 = "";
              localObject4 = localObject2;
              i = j;
              localObject2 = str3;
              j = i1;
              break label410;
            }
            localObject5 = localObject4;
            localObject1 = localObject4;
            i1 = i;
            str3 = "";
            localObject4 = localObject2;
            i = j;
            localObject2 = str3;
            j = i1;
            break label410;
            i = ((String)localObject1).indexOf(',');
            localObject2 = ((String)localObject1).substring(0, i);
            localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
            j = Integer.parseInt((String)localObject2);
            i = ((String)localObject1).indexOf(',');
            localObject2 = ((String)localObject1).substring(0, i);
            localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
            i = Integer.parseInt((String)localObject2);
            k = ((String)localObject1).indexOf(',');
            localObject2 = ((String)localObject1).substring(0, k);
            localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
            i1 = Integer.parseInt((String)localObject2);
            k = ((String)localObject1).indexOf(',');
            if (k != -1)
            {
              localObject2 = ((String)localObject1).substring(0, k);
              localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
              localObject4 = null;
              k = i;
              i = j;
              j = k;
              k = i1;
              break label410;
            }
            localObject4 = null;
            localObject2 = localObject1;
            k = i;
            i = j;
            j = k;
            k = i1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.e(TAG, 2, "getHightlightMsgText ==>NumberFormatException");
                l1 = l2;
              }
            }
          }
        }
      }
      i = 0;
      while (i < localArrayList.size() - 1)
      {
        j = i + 1;
        while (j < localArrayList.size())
        {
          if (((hyx)localArrayList.get(i)).jdField_a_of_type_Int > ((hyx)localArrayList.get(j)).jdField_a_of_type_Int)
          {
            localObject1 = (hyx)localArrayList.get(i);
            localArrayList.add(i, localArrayList.get(j));
            localArrayList.add(j, localObject1);
          }
          j += 1;
        }
        i += 1;
      }
      Object localObject4 = (FriendsManagerImp)paramQQAppInterface.getManager(8);
      Object localObject5 = localArrayList.iterator();
      paramQQAppInterface = str2;
      localObject1 = "";
      i = 0;
      if (((Iterator)localObject5).hasNext())
      {
        Object localObject3 = (hyx)((Iterator)localObject5).next();
        str2 = (String)localObject1 + paramQQAppInterface.substring(0, ((hyx)localObject3).jdField_a_of_type_Int - i);
        str3 = paramQQAppInterface.substring(((hyx)localObject3).jdField_a_of_type_Int - i, ((hyx)localObject3).b - i);
        localObject1 = paramQQAppInterface.substring(((hyx)localObject3).b - i, paramQQAppInterface.length());
        i = ((hyx)localObject3).b;
        ((hyx)localObject3).jdField_a_of_type_Int = str2.length();
        if (((hyx)localObject3).jdField_a_of_type_Boolean) {}
        for (paramQQAppInterface = str2 + ((FriendsManagerImp)localObject4).a(this.frienduin, new StringBuilder().append("").append(((hyx)localObject3).jdField_a_of_type_Long).toString());; paramQQAppInterface = str2 + str3)
        {
          ((hyx)localObject3).b = paramQQAppInterface.length();
          localObject3 = paramQQAppInterface;
          paramQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = localObject3;
          break;
        }
      }
      paramQQAppInterface = new SpannableStringBuilder((String)localObject1 + paramQQAppInterface);
      i = paramContext.getResources().getColor(2131427448);
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext())
      {
        localObject1 = (hyx)paramContext.next();
        if (localObject1 != null) {
          paramQQAppInterface.setSpan(new ForegroundColorSpan(i), ((hyx)localObject1).jdField_a_of_type_Int, ((hyx)localObject1).b, 33);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public void switch2HightlightMsg() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */