package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import igy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FavoriteEmoticonInfo
  extends EmoticonInfo
{
  static long a = 0L;
  static final long b = 1000L;
  public String i;
  
  public FavoriteEmoticonInfo()
  {
    this.b = "show_fav_menu";
  }
  
  public static List a(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FavoriteEmoticonInfo", 2, "FavoriteEmoticonInfo getEmoticonList context=" + paramBaseActivity);
      }
      return new ArrayList();
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)paramBaseActivity.app.getManager(13);
    Object localObject1 = paramBaseActivity.app.a().createEntityManager();
    List localList = ((EntityManager)localObject1).a(CustomEmotionData.class, false, null, null, null, null, null, null);
    ((EntityManager)localObject1).a();
    localObject1 = new ArrayList();
    if (localList != null)
    {
      int j = localList.size() - 1;
      if (j >= 0)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        Object localObject2;
        if (localCustomEmotionData.isMarkFace)
        {
          localObject2 = new PicEmoticonInfo(paramBaseActivity.app.a());
          ((PicEmoticonInfo)localObject2).c = 6;
          String str = localCustomEmotionData.eId;
          ((PicEmoticonInfo)localObject2).a = localEmoticonManager.a(localCustomEmotionData.emoPath, str);
          ((List)localObject1).add(localObject2);
        }
        for (;;)
        {
          j -= 1;
          break;
          localObject2 = new FavoriteEmoticonInfo();
          ((FavoriteEmoticonInfo)localObject2).c = 5;
          ((FavoriteEmoticonInfo)localObject2).i = localCustomEmotionData.emoPath;
          ((List)localObject1).add(localObject2);
        }
      }
    }
    return localObject1;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    paramContext = null;
    URL localURL = FavoriteDownloader.a(this.i, 100, 100);
    ColorDrawable localColorDrawable = new ColorDrawable();
    if (localURL != null) {
      paramContext = URLDrawable.getDrawable(localURL, localColorDrawable, null);
    }
    return paramContext;
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, EmoticonCallback paramEmoticonCallback)
  {
    String[] arrayOfString = paramContext.getResources().getStringArray(2131230727);
    paramContext = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    paramContext.a(arrayOfString[0], 1);
    paramContext.a(arrayOfString[1], 1);
    paramContext.e(2131365736);
    paramContext.a(new igy(this, paramQQAppInterface, paramEmoticonCallback, paramContext));
    paramContext.show();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - a < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    a = l;
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.i);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    int k = 0;
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(CustomEmotionData.class, false, " emoPath = ?", new String[] { this.i }, null, null, null, null);
    int j;
    if (localList != null)
    {
      j = 0;
      while (j < localList.size())
      {
        localEntityManager.b((CustomEmotionData)localList.get(j));
        j += 1;
      }
    }
    localList = localEntityManager.a(RecentEmotionData.class, false, " emoPath = ?", new String[] { this.i }, null, null, null, null);
    if (localList != null)
    {
      j = k;
      while (j < localList.size())
      {
        localEntityManager.b((RecentEmotionData)localList.get(j));
        j += 1;
      }
    }
    localEntityManager.a();
    paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.obtainMessage(10).sendToTarget();
    }
    return true;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */