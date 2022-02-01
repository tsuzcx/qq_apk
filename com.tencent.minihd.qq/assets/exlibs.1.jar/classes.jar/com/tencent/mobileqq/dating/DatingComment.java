package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.service.message.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatingComment
{
  public int a;
  public long a;
  public DatingStranger a;
  public String a;
  public DatingStranger b;
  public String b;
  public String c;
  public String d;
  public String e;
  @notColumn
  public String f;
  
  public static appoint_define.RichText a(String paramString)
  {
    appoint_define.RichText localRichText = new appoint_define.RichText();
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      Object localObject;
      if (i < paramString.length())
      {
        if (paramString.charAt(i) == '\024')
        {
          appoint_define.Elem localElem;
          if (localStringBuilder.length() > 0)
          {
            localObject = localStringBuilder.toString();
            localElem = new appoint_define.Elem();
            localElem.str_content.set((String)localObject);
            localRichText.rpt_msg_elems.add(localElem);
            localStringBuilder.delete(0, localStringBuilder.length());
          }
          j = i;
          if (i + 1 < paramString.length())
          {
            int k = paramString.charAt(i + 1);
            j = i;
            if (k >= 0)
            {
              j = i;
              if (k < MessageUtils.a.length)
              {
                localObject = new appoint_define.Face();
                ((appoint_define.Face)localObject).uint32_index.set(MessageUtils.a[k]);
                localElem = new appoint_define.Elem();
                localElem.msg_face_info.set((MessageMicro)localObject);
                localRichText.rpt_msg_elems.add(localElem);
              }
            }
          }
        }
        for (int j = i + 1;; j = i)
        {
          i = j + 1;
          break;
          localStringBuilder.append(paramString.charAt(i));
        }
      }
      if (localStringBuilder.length() > 0)
      {
        paramString = localStringBuilder.toString();
        localObject = new appoint_define.Elem();
        ((appoint_define.Elem)localObject).str_content.set(paramString);
        localRichText.rpt_msg_elems.add((MessageMicro)localObject);
        localStringBuilder.delete(0, localStringBuilder.length());
      }
    }
    return localRichText;
  }
  
  public static DatingComment a(appoint_define.DateComment paramDateComment)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramDateComment.str_comment_id.get()))) {
      return null;
    }
    DatingComment localDatingComment = new DatingComment();
    localDatingComment.jdField_a_of_type_JavaLangString = paramDateComment.str_comment_id.get();
    localDatingComment.jdField_b_of_type_JavaLangString = DatingUtil.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
    localDatingComment.jdField_a_of_type_Long = paramDateComment.uint32_time.get();
    appoint_define.RichText localRichText;
    int i;
    if (paramDateComment.msg_content.has())
    {
      localRichText = (appoint_define.RichText)paramDateComment.msg_content.get();
      localDatingComment.c = a(localRichText);
      localDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      if (!paramDateComment.uint32_flag.has()) {
        break label220;
      }
      i = paramDateComment.uint32_flag.get();
      label131:
      localDatingComment.jdField_a_of_type_Int = i;
      if (!paramDateComment.msg_reply_info.has()) {
        break label225;
      }
    }
    label220:
    label225:
    for (paramDateComment = (appoint_define.ReplyInfo)paramDateComment.msg_reply_info.get();; paramDateComment = null)
    {
      if (paramDateComment != null)
      {
        localDatingComment.d = paramDateComment.str_comment_id.get();
        localDatingComment.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a((appoint_define.StrangerInfo)paramDateComment.msg_stranger_info.get());
      }
      localDatingComment.f = DatingUtil.a(localDatingComment.jdField_a_of_type_Long, true);
      localDatingComment.e = DatingUtil.a(localDatingComment.jdField_a_of_type_Long, false);
      return localDatingComment;
      localRichText = null;
      break;
      i = 0;
      break label131;
    }
  }
  
  public static DatingComment a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    DatingComment localDatingComment = new DatingComment();
    try
    {
      localDatingComment.jdField_a_of_type_JavaLangString = paramJSONObject.getString("commentId");
      localDatingComment.jdField_b_of_type_JavaLangString = paramJSONObject.getString("datingId");
      localDatingComment.c = paramJSONObject.getString("content");
      localDatingComment.jdField_a_of_type_Long = paramJSONObject.getLong("time");
      localDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a(paramJSONObject.getJSONObject("puber"));
      localDatingComment.jdField_a_of_type_Int = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          localDatingComment.d = paramJSONObject.getString("replyId");
          try
          {
            localDatingComment.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a(paramJSONObject.getJSONObject("replyer"));
            return localDatingComment;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return localDatingComment;
          }
          localJSONException1 = localJSONException1;
          localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {}
    for (paramRichText = paramRichText.rpt_msg_elems.get(); (paramRichText == null) || (paramRichText.isEmpty()); paramRichText = null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramRichText.iterator();
    label135:
    label196:
    label199:
    label201:
    label204:
    while (localIterator.hasNext())
    {
      appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
      if (localElem != null)
      {
        if (localElem.str_content.has())
        {
          paramRichText = localElem.str_content.get();
          label106:
          localStringBuilder.append(paramRichText);
          if (!localElem.msg_face_info.has()) {
            break label196;
          }
          paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          if (paramRichText == null) {
            break label199;
          }
          if (!paramRichText.uint32_index.has()) {
            break label201;
          }
        }
        for (int i = paramRichText.uint32_index.get();; i = -1)
        {
          if ((i < 0) || (i >= MessageUtils.b.length)) {
            break label204;
          }
          localStringBuilder.append('\024');
          localStringBuilder.append((char)MessageUtils.b[i]);
          break;
          paramRichText = "";
          break label106;
          paramRichText = null;
          break label135;
          break;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((DatingComment)paramList.next());
      if (localJSONObject == null) {
        break label83;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label83:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DatingComment localDatingComment = a((appoint_define.DateComment)paramList.next());
      if (localDatingComment != null) {
        localArrayList.add(localDatingComment);
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(DatingComment paramDatingComment)
  {
    if (paramDatingComment == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramDatingComment.jdField_a_of_type_JavaLangString);
      localJSONObject.put("datingId", paramDatingComment.jdField_b_of_type_JavaLangString);
      localJSONObject.put("content", paramDatingComment.c);
      localJSONObject.put("time", paramDatingComment.jdField_a_of_type_Long);
      localJSONObject.put("replyId", paramDatingComment.d);
      localJSONObject.put("puber", DatingStranger.a(paramDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger));
      localJSONObject.put("replyer", DatingStranger.a(paramDatingComment.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger));
      localJSONObject.put("flag", paramDatingComment.jdField_a_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException paramDatingComment)
    {
      paramDatingComment.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          DatingComment localDatingComment = a(paramString.getJSONObject(i));
          if (localDatingComment != null) {
            paramList.add(localDatingComment);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (DatingComment)paramObject;
    } while (((this.jdField_a_of_type_JavaLangString != null) || (paramObject.jdField_a_of_type_JavaLangString != null)) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString))));
    return true;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "".hashCode();
    }
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.c).append(",").append(this.jdField_a_of_type_Long).append(",").append(this.d).append(",").append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger).append(",").append(this.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger).append(",").append(this.jdField_a_of_type_Int).append(",").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingComment
 * JD-Core Version:    0.7.0.1
 */