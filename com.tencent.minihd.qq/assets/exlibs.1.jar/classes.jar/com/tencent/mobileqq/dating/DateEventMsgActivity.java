package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import hzl;
import hzn;
import hzo;
import hzq;

public class DateEventMsgActivity
  extends DatingBaseActivity
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ExpandableListView.OnGroupClickListener
{
  public static final int a = 0;
  private static long a = 0L;
  public static final int b = 1;
  public static final int c = 2;
  public FPSPinnedHeaderExpandableListView a;
  public FaceDecoder a;
  public hzo a;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  private void a()
  {
    ThreadManager.a().post(new hzl(this));
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = System.nanoTime();
      l2 = Math.abs(l1 - jdField_a_of_type_Long);
    } while ((l2 >= 0L) && (l2 < 1000L));
    jdField_a_of_type_Long = l1;
    Intent localIntent = new Intent(paramContext, DateEventMsgActivity.class);
    localIntent.putExtra("from", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    DatingUtil.a("onDecodeTaskCompleted", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramBitmap });
    if ((paramInt2 != 32) || (paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getChildCount();
    paramInt1 = 0;
    label61:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getChildAt(paramInt1);
      if (localObject != null) {
        break label88;
      }
    }
    label178:
    for (;;)
    {
      paramInt1 += 1;
      break label61;
      break;
      label88:
      localObject = ((View)localObject).getTag();
      if ((localObject instanceof hzn))
      {
        hzn localhzn = (hzn)localObject;
        if ((localhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg != null) && (localhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info != null)) {}
        for (localObject = String.valueOf(localhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info.jdField_a_of_type_Long);; localObject = null)
        {
          if (!paramString.equals(localObject)) {
            break label178;
          }
          localhzn.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(new BitmapDrawable(paramBitmap));
          break;
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
    {
      DatingUtil.b("isNeedPauseAsyncWork", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getChildCount();
    int i = 0;
    label70:
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getChildAt(i);
      if (localObject != null) {
        break label97;
      }
    }
    label97:
    do
    {
      i += 1;
      break label70;
      break;
      localObject = ((View)localObject).getTag();
    } while (!(localObject instanceof hzn));
    hzn localhzn = (hzn)localObject;
    if ((localhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg != null) && (localhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info != null)) {}
    for (Object localObject = String.valueOf(localhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info.jdField_a_of_type_Long);; localObject = null)
    {
      localObject = DatingUtil.a((String)localObject, this.app, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
      localhzn.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
      break;
    }
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    b("0X8004F16");
    paramExpandableListView = (hzq)this.jdField_a_of_type_Hzo.getGroup(paramInt);
    if (paramExpandableListView != null) {
      switch (paramExpandableListView.b)
      {
      default: 
        paramExpandableListView = null;
      }
    }
    for (;;)
    {
      if (paramExpandableListView != null) {
        b(paramExpandableListView);
      }
      return false;
      paramExpandableListView = "0X8004F17";
      continue;
      paramExpandableListView = "0X8004F18";
      continue;
      paramExpandableListView = "0X8004F19";
      continue;
      paramExpandableListView = "0X8004F1A";
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903890);
    getWindow().setBackgroundDrawableResource(2130837687);
    setTitle(2131369751);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView = ((FPSPinnedHeaderExpandableListView)findViewById(2131299980));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOnGroupClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setHeaderDividersEnabled(false);
    paramBundle = new View(this);
    paramBundle.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.a(paramBundle);
    this.jdField_a_of_type_Hzo = new hzo(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Hzo);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DateEventMsgActivity
 * JD-Core Version:    0.7.0.1
 */