package com.tencent.mobileqq.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.CirclePageIndicator;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jnb;
import jnc;
import jnd;
import jne;
import jnf;
import jnh;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipProfileCardPreviewActivity
  extends VipProfileCardBaseActivity
  implements View.OnClickListener
{
  public static final int G = 0;
  public static final int H = 1;
  public static final int I = 2;
  public static final int J = 3000;
  public static final int K = 1500;
  public static final int M = -1;
  public static final int N = 0;
  public static final int O = 1;
  public static final int P = 2;
  public static final int Q = 640;
  public static final int R = 1136;
  public static final int S = 2;
  public static final int T = 45;
  public static final int U = 15;
  public static final int V = 15;
  public static final int W = 15;
  public static final int X = 3;
  public static final int Y = 7;
  public static final int Z = 20;
  public static final int aa = 15;
  public static final int ab = 18;
  public static final int ac = 40;
  public static final int ad = 10;
  public static final int ae = 11;
  public static final int af = 11;
  public static final int ag = 3;
  public static final int ah = 7;
  public static final int ai = 20;
  public static final int aj = 15;
  public static final int ak = 16;
  public static final float b = 1.78F;
  public static final float c = 14.5F;
  public static final float d = 16.5F;
  public static final String i = "ProfileCard.VipProfileCardPreviewActivity";
  public static final String k = "com.tencent.mobileqq.action.closeWeb";
  public int L = -1;
  public Drawable a;
  public SparseArray a;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public ProfileCardBackground a;
  public ProfileCardTemplate a;
  public VipProfileCardPreviewActivity.StylePagerAdapter a;
  public VipScaledViewPager a;
  public CirclePageIndicator a;
  private HashMap a;
  public List a;
  public int al = 0;
  public int am = 0;
  public int an = 0;
  public int ao = 0;
  public int ap = 0;
  public int aq = 0;
  public int ar = 0;
  public int as = 0;
  public int at = 0;
  public int au = 0;
  public int av = -1;
  public int aw;
  public int ax;
  public int ay;
  private int az = 0;
  public long b;
  public View b;
  public Button b;
  public TextView b;
  private Runnable b;
  public ArrayList b;
  public List b;
  public Button c;
  public TextView c;
  public boolean c;
  private volatile boolean d = false;
  public float e = 0.0F;
  public float f = 1.0F;
  public float g = 1.666667F;
  public float h = 1.775F;
  public String j = "0";
  private String l = null;
  
  public VipProfileCardPreviewActivity()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = 1;
    int n = 1;
    int i2 = n;
    if (paramInt1 != 0)
    {
      i2 = n;
      if (paramInt2 != 0)
      {
        i2 = n;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i2 = n;
        }
      }
    }
    label43:
    int i1;
    label55:
    do
    {
      do
      {
        return i2;
        n = paramOptions.outHeight;
        i1 = paramOptions.outWidth;
        i2 = m;
      } while (n <= paramInt2);
      i2 = m;
    } while (i1 <= paramInt1);
    int i3 = Math.round(n / paramInt2);
    i2 = Math.round(i1 / paramInt1);
    if (i3 > i2) {}
    for (;;)
    {
      i2 = m;
      if (i3 < 2) {
        break;
      }
      i1 /= 2;
      n /= 2;
      m *= 2;
      break label55;
      i3 = i2;
    }
  }
  
  private long a()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    return ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h;
  }
  
  private BitmapDrawable a(String paramString, boolean paramBoolean)
  {
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)BaseApplicationImpl.a.get(paramString);
    Object localObject3 = localBitmapDrawable;
    Object localObject1;
    int m;
    if (localBitmapDrawable == null)
    {
      localObject1 = Bitmap.Config.ARGB_8888;
      m = 1;
      if (m > 2) {
        break label283;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject3).inPreferredConfig = ((Bitmap.Config)localObject1);
        ((BitmapFactory.Options)localObject3).inDensity = this.F;
        ((BitmapFactory.Options)localObject3).inTargetDensity = this.F;
        ((BitmapFactory.Options)localObject3).inScreenDensity = this.F;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject3);
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
        if (paramBoolean) {
          ((BitmapFactory.Options)localObject3).inSampleSize = a((BitmapFactory.Options)localObject3, this.ax, this.aw);
        }
        localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject3);
        localObject3 = localBitmapDrawable;
        if (localObject1 != null)
        {
          localObject3 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          BaseApplicationImpl.a.put(paramString, localObject3);
        }
        return localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "getFrameBitmap oom path = " + paramString + ", try count : " + m);
        }
        Bitmap.Config localConfig = Bitmap.Config.ARGB_4444;
        m += 1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "getFrameBitmap oom path = " + paramString + ", msg = " + localException.getMessage() + ", try count : " + m);
        }
        localObject2 = null;
        continue;
      }
      label283:
      Object localObject2 = null;
    }
  }
  
  private void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "url from UPS:" + paramUpsImageUploadResult.url);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramUpsImageUploadResult.url);
    b(paramString, paramUpsImageUploadResult.url);
  }
  
  private void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        localResources = this.app.a().getResources();
        BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
        m = ((BitmapFactory.Options)localObject).outHeight;
        n = ((BitmapFactory.Options)localObject).outWidth;
        float f1 = this.E / this.D;
        i1 = Math.min(n, (int)(m * f1));
        i2 = (int)(i1 / f1);
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
        paramString1 = BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "image info imageWidth=" + i1 + ",imageHeight=" + i2);
      }
      catch (OutOfMemoryError paramString1)
      {
        Object localObject;
        Resources localResources;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "OutOfMemoryError" + paramString1.getMessage());
        return;
      }
      catch (Exception paramString1)
      {
        int m;
        int n;
        int i1;
        int i2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "Exception when init background:" + paramString1.getMessage());
        return;
        if (paramString1 == null) {
          return;
        }
        if ((n != i1) || (m != i2)) {
          continue;
        }
        continue;
      }
      if (paramString1 == null) {
        return;
      }
      m = Utils.a(paramString1);
      paramString1 = new BitmapDrawable(localResources, paramString1);
      paramString1.setTargetDensity(localResources.getDisplayMetrics());
      if (paramString2 != null) {
        BaseApplicationImpl.a.put(paramString2, new Pair(paramString1.getConstantState(), Integer.valueOf(m)));
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString1;
      return;
      localObject = Bitmap.createBitmap(paramString1, 0, 0, i1, i2);
      paramString1.recycle();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "Background size not match screen size, create a new one to resize");
      }
      paramString1 = (String)localObject;
    }
  }
  
  private void a(long[] paramArrayOfLong)
  {
    int n = 0;
    int m = 0;
    int i1 = 0;
    if (n < paramArrayOfLong.length)
    {
      long l1 = paramArrayOfLong[n];
      int i2;
      if (l1 == this.jdField_a_of_type_Long)
      {
        this.av = n;
        m = 1;
        i2 = 1;
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l1));
        n += 1;
        i1 = i2;
        break;
        i2 = i1;
        if (l1 == this.jdField_b_of_type_Long)
        {
          if (i1 == 0) {
            this.av = n;
          }
          m = 1;
          i2 = i1;
        }
      }
    }
    if ((m == 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
      if (this.av == -1) {
        this.av = (this.jdField_b_of_type_JavaUtilArrayList.size() - 1);
      }
    }
    if (this.av == -1)
    {
      this.av = 0;
      this.jdField_c_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg mWebStyleList = " + this.jdField_b_of_type_JavaUtilArrayList.toString() + ", mCurrentStyleId = " + this.jdField_a_of_type_Long + ", mWebStyleId = " + this.jdField_b_of_type_Long + ", mCurrentViewPos = " + this.av + ", mStyleListNull = " + this.jdField_c_of_type_Boolean);
    }
  }
  
  private void b(String paramString)
  {
    jnh localjnh = new jnh(this, Long.parseLong(this.app.a()), paramString, VipUploadUtils.a(this.app), "qqprofile", paramString);
    localjnh.b = VipUploadUtils.a(this.app);
    localjnh.n = VipUploadUtils.a(this.app, paramString);
    l();
    localjnh.a();
    ((VipImageUploadManager)this.app.getManager(84)).a(this.app, localjnh, null);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    ProfileCardBackground localProfileCardBackground;
    ProfileCardTemplate localProfileCardTemplate;
    do
    {
      return;
      localProfileCardBackground = new ProfileCardBackground();
      localProfileCardBackground.jdField_a_of_type_Int = 160;
      localProfileCardTemplate = ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem())).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
    } while ((localProfileCardTemplate == null) || (this.d) || (isFinishing()) || (!a(localProfileCardTemplate, localProfileCardBackground, true)));
    a(a(), 0L, paramString2, ProfileCardUtil.a(paramString1));
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    Object localObject;
    do
    {
      do
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).a;
          localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while (localProfileCardTemplateInfo == null);
        switch (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_NONE");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_SCROLL");
      }
      ((ProfileCardScrollImageView)localObject).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_FADE_IN_OUT");
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while ((localObject == null) || (!(localObject instanceof TransitionDrawable)));
    ((TransitionDrawable)localObject).resetTransition();
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localView.getTag(), (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369078);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 30000L);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void m()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
  }
  
  private void n()
  {
    if (!TextUtils.isEmpty(this.l))
    {
      File localFile = new File(this.l);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h == paramLong) {
          return m;
        }
        m += 1;
      }
    }
    return -1;
  }
  
  public ProfileCardTemplateInfo a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(m);
        if (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h == paramLong) {
          return localProfileCardTemplateInfo;
        }
        m += 1;
      }
    }
    return null;
  }
  
  public List a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null)) {}
    for (;;)
    {
      return localArrayList;
      if (this.z == 1) {
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.o);
      }
      while (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d == 2)
      {
        if (this.z != 1) {
          break label95;
        }
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.s);
        return localArrayList;
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.k);
      }
    }
    label95:
    localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.w);
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem());
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    do
    {
      do
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).a;
          localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while ((localProfileCardTemplateInfo == null) || (((ProfileCardScrollImageView)localObject).getTag() == null));
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startAnimation pos = " + paramInt);
        }
        switch (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "no animation to start !");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
      }
      ((ProfileCardScrollImageView)localObject).setScrollDuration(1500);
      ((ProfileCardScrollImageView)localObject).a(this.ay);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_FADE_IN_OUT");
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while (!(localObject instanceof TransitionDrawable));
    Object localObject = (TransitionDrawable)localObject;
    ((TransitionDrawable)localObject).setCrossFadeEnabled(true);
    ((TransitionDrawable)localObject).startTransition(1500);
    this.jdField_b_of_type_JavaLangRunnable = new jnd(this, (TransitionDrawable)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
  }
  
  public void a(int paramInt, ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if (paramProfileCardTemplateInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startDownload pos = " + paramInt + ", status = " + paramProfileCardTemplateInfo.jdField_a_of_type_Int);
      }
    } while ((paramProfileCardTemplateInfo.jdField_a_of_type_Int == 2) || (paramProfileCardTemplateInfo.jdField_a_of_type_Int == 1));
    paramProfileCardTemplateInfo.jdField_a_of_type_Int = 1;
    paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
    this.jdField_b_of_type_JavaUtilList.addAll(paramProfileCardTemplateInfo);
    a(paramInt, paramProfileCardTemplateInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.a(new jnf(this, paramInt, paramString));
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (String)paramList.next());
      }
    }
  }
  
  public void a(VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder paramViewHolder, ProfileCardTemplateInfo paramProfileCardTemplateInfo, int paramInt)
  {
    Object localObject;
    if (a(paramProfileCardTemplateInfo))
    {
      paramProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "loadImageDrawable pos = " + paramInt + " info exist");
      }
      localObject = a(paramProfileCardTemplateInfo);
      if ((localObject != null) && (((List)localObject).size() != 0)) {
        break label113;
      }
    }
    label73:
    label113:
    do
    {
      do
      {
        do
        {
          break label73;
          do
          {
            do
            {
              do
              {
                return;
              } while (!QLog.isColorLevel());
              QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "loadImageDrawable pos = " + paramInt + " info not exist");
              return;
              switch (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
              {
              default: 
                return;
              case 0: 
                paramViewHolder.a.setIsScroll(false);
                paramProfileCardTemplateInfo = URLDrawable.getDrawable("file://" + ProfileCardUtil.b(this.jdField_a_of_type_AndroidContentContext, (String)((List)localObject).get(0)), this.ax, this.aw, paramViewHolder.a.getDrawable(), paramViewHolder.a.getDrawable(), false);
                paramViewHolder.a.setImageDrawable(paramProfileCardTemplateInfo);
                paramViewHolder.a.setTag(Integer.valueOf(paramInt));
                return;
              case 1: 
                paramViewHolder.a.setIsScroll(true);
                paramProfileCardTemplateInfo = a(ProfileCardUtil.b(this.jdField_a_of_type_AndroidContentContext, (String)((List)localObject).get(0)), false);
              }
            } while (paramProfileCardTemplateInfo == null);
            int m = paramProfileCardTemplateInfo.getBitmap().getWidth();
            int n = paramProfileCardTemplateInfo.getBitmap().getHeight() * this.ax / m;
            this.ay = (this.aw - n);
            paramViewHolder.a.setScaleType(ImageView.ScaleType.MATRIX);
            localObject = new Matrix();
            ((Matrix)localObject).postScale(this.ax / m, this.ax / m);
            paramViewHolder.a.setImageMatrix((Matrix)localObject);
            paramViewHolder.a.setImageDrawable(paramProfileCardTemplateInfo);
            paramViewHolder.a.setTag(Integer.valueOf(paramInt));
          } while (this.av != paramInt);
          a(paramInt);
          return;
          paramViewHolder.a.setIsScroll(false);
        } while ((((List)localObject).size() <= 1) || (TextUtils.isEmpty((CharSequence)((List)localObject).get(1))));
        long l1 = System.currentTimeMillis();
        paramProfileCardTemplateInfo = ProfileCardUtil.b(this.jdField_a_of_type_AndroidContentContext, (String)((List)localObject).get(1));
        localObject = ProfileCardUtil.b(this.jdField_a_of_type_AndroidContentContext, (String)((List)localObject).get(0));
        paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo, true);
        localObject = a((String)localObject, true);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "ANIMATION_SCROLL time " + (l1 - System.currentTimeMillis()));
        }
      } while ((localObject == null) || (paramProfileCardTemplateInfo == null));
      paramProfileCardTemplateInfo = new TransitionDrawable(new Drawable[] { localObject, paramProfileCardTemplateInfo });
      paramViewHolder.a.setImageDrawable(paramProfileCardTemplateInfo);
      paramViewHolder.a.setTag(Integer.valueOf(paramInt));
    } while (this.av != paramInt);
    a(paramInt);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ProfileCardUtil.b(this.jdField_a_of_type_AndroidContentContext, paramString);
      localObject = new File(paramString);
      if ((((File)localObject).isFile()) && (((File)localObject).exists()))
      {
        localObject = "profilecard:" + paramString;
        Pair localPair = (Pair)BaseApplicationImpl.a.get(localObject);
        if ((localPair == null) || (localPair.first == null)) {
          break label129;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "get image form sImageCache filePath=" + paramString);
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localPair.first).newDrawable();
      }
    }
    return;
    label129:
    a(paramString, (String)localObject);
  }
  
  @TargetApi(16)
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      if (paramMessage.what != 2) {
        break label195;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      break;
    }
    for (;;)
    {
      return true;
      paramMessage = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getLayoutParams();
      paramMessage.height = this.L;
      paramMessage.topMargin = this.as;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayoutParams(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setScale(this.e);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setGap(this.at);
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter = new VipProfileCardPreviewActivity.StylePagerAdapter(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter);
      j();
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setCurrentItem(this.av);
      b(this.av);
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label195:
    if (paramMessage.what == 3)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131369060, 0).show();
      return true;
    }
    if (paramMessage.what == 20)
    {
      d(paramMessage.arg1);
      return true;
    }
    if (paramMessage.what == 5)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131369058, 0).show();
      if ((this.x == 1) || (this.x == 2)) {
        if (this.az == 1) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.msg.permission.pushnotify2");
        }
      }
      for (;;)
      {
        new Thread(new jnb(this)).start();
        finish();
        return true;
        paramMessage = new Intent(this, FriendProfileCardActivity.class);
        paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.a(), 0));
        paramMessage.setFlags(67108864);
        startActivity(paramMessage);
        continue;
        paramMessage = new Intent(this, FriendProfileCardActivity.class);
        paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.a(), 0));
        paramMessage.setFlags(67108864);
        startActivity(paramMessage);
      }
    }
    if (paramMessage.what == 21)
    {
      ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramMessage.arg1)).jdField_a_of_type_Int = -1;
      return true;
    }
    if ((paramMessage.what == 24) || (paramMessage.what == 25))
    {
      if (paramMessage.what == 25) {
        b();
      }
      Toast.makeText(getApplicationContext(), getResources().getString(2131369077), 1).show();
    }
    return false;
  }
  
  public boolean a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null)) {
      return false;
    }
    paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.size() == 0)) {
      return false;
    }
    paramProfileCardTemplateInfo = paramProfileCardTemplateInfo.iterator();
    while (paramProfileCardTemplateInfo.hasNext())
    {
      String str = (String)paramProfileCardTemplateInfo.next();
      if (!ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, str)) {
        return false;
      }
    }
    return true;
  }
  
  protected void addTopLayout() {}
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)) {
      return;
    }
    a(((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, false);
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131369070);
      this.j = "2";
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131369069);
      this.j = "1";
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131369065);
    this.j = "0";
  }
  
  @TargetApi(16)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = false;
    setContentView(2130904130);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300431);
    float f1;
    if ((this.app != null) && (ThemeUtil.isInNightMode(this.app)))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131300955));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131300968));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)findViewById(2131296634));
      if (Build.MODEL.equals("HUAWEI C8812E")) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayerType(1, null);
      }
      this.f = (this.jdField_a_of_type_Float / 2.0F);
      if (this.D / this.E <= (this.g + this.h) / 2.0F) {
        break label689;
      }
      f1 = this.D / (1136.0F * this.f);
      this.al = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.am = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.an = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.ao = ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 45);
      this.ap = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.ar = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.aq = Math.round(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.5F) * f1);
      this.as = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.at = Math.round(f1 * ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.e = 0.824503F;
      this.au = 18;
    }
    for (;;)
    {
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetButton.getLayoutParams();
      paramBundle.height = this.ao;
      int m = this.an;
      paramBundle.leftMargin = m;
      paramBundle.rightMargin = m;
      paramBundle.bottomMargin = this.am;
      this.jdField_c_of_type_AndroidWidgetButton.setTextSize(1, this.au);
      this.jdField_c_of_type_AndroidWidgetButton.setLayoutParams(paramBundle);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.getLayoutParams();
      paramBundle.topMargin = this.aq;
      paramBundle.bottomMargin = this.aq;
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setLayoutParams(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(this.ar);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setRadius(this.ap);
      m = getResources().getDimensionPixelSize(2131492923);
      int n = ProfileCardUtil.a(getResources());
      this.L = (this.D - this.as - this.am - this.ao - this.ap * 2 - this.aq * 2 - m - n);
      this.aw = this.L;
      this.ax = Math.round(this.aw / 1.78F);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setStrokeWidth(0.0F);
      k();
      h();
      i();
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new jnc(this));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (this.app != null) {
        ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004D59", "0X8004D59", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
      }
      return true;
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      label689:
      f1 = this.D / (800.0F * this.f);
      this.al = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.am = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 10) * f1);
      this.an = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.ao = ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 40);
      this.ap = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.ar = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.aq = Math.round(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.5F) * f1);
      this.as = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.at = Math.round(f1 * ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.au = 16;
      this.e = 0.8192771F;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.d = true;
  }
  
  public void h()
  {
    setLeftViewName(2131366374);
    setTitle(2131369066);
  }
  
  public void i()
  {
    ThreadManager.b(new jne(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.av != -1)
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.av);
        a(this.av, localProfileCardTemplateInfo);
      }
      int m = 0;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.av != -1) && (m == this.av)) {}
        for (;;)
        {
          m += 1;
          break;
          a(m, (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(m));
        }
      }
    }
  }
  
  public void k()
  {
    int m = 0;
    g();
    Object localObject = getIntent();
    if (localObject != null)
    {
      String str;
      if (((Intent)localObject).hasExtra("preview"))
      {
        this.az = 0;
        str = ((Intent)localObject).getStringExtra("preview");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg preview = " + str);
        }
        try
        {
          localObject = new JSONObject(str);
          if (((JSONObject)localObject).has("entryId")) {
            this.x = ((JSONObject)localObject).getInt("entryId");
          }
          localObject = ((JSONObject)localObject).getJSONObject("item");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground = new ProfileCardBackground();
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("thumb_url");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("auth");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.d = ((JSONObject)localObject).optInt("limitefree_type");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.e = ((JSONObject)localObject).optInt("limitefree_btime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.f = ((JSONObject)localObject).optInt("limitefree_etime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.m = ((JSONObject)localObject).optInt("color");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.g = ((JSONObject)localObject).optInt("tag");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.h = ((JSONObject)localObject).optInt("tag_btime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.i = ((JSONObject)localObject).optInt("tag_etime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.j = ((JSONObject)localObject).optInt("background_btime");
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.k = ((JSONObject)localObject).optInt("background_etime");
          this.z = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.m;
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground);
          this.jdField_b_of_type_Long = ((JSONObject)localObject).optInt("style");
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int == 160)
          {
            this.jdField_b_of_type_Long = 1L;
            localObject = a();
            a((long[])localObject);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString);
            return;
          }
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("style_list");
          long[] arrayOfLong = new long[localJSONArray.length()];
          for (;;)
          {
            localObject = arrayOfLong;
            if (m >= localJSONArray.length()) {
              break;
            }
            arrayOfLong[m] = localJSONArray.getLong(m);
            m += 1;
          }
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg JSONException json = " + str);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
      }
      else if (localJSONException.hasExtra("custom_card_background"))
      {
        this.az = 1;
        this.l = localJSONException.getStringExtra("custom_card_background");
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground = new ProfileCardBackground();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int = 160;
        this.jdField_b_of_type_Long = 1L;
        a(a());
        a(this.l, null);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004C28", "0X8004C28", 0, 0, "", "", "", VipUtils.a(this.app, this.app.a()));
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
        ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004C27", "0X8004C27", 0, 0, "", "", this.j, VipUtils.a(this.app, this.app.a()));
        if (this.az != 0) {
          break;
        }
        int m = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
        paramView = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(m);
      } while (!a(paramView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, true));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int != 160)
      {
        a(paramView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int);
        return;
      }
      a(a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.m);
      return;
    } while (this.az != 1);
    ProfileCardUtil.a(this.l, 100, 0.56338F);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get(this.l)))
    {
      b(this.l, (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.l));
      return;
    }
    b(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity
 * JD-Core Version:    0.7.0.1
 */