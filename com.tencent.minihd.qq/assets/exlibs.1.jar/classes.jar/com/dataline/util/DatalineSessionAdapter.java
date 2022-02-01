package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.file.FileUtil;
import com.dataline.util.widget.AsyncImageView;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.DateLineFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import do;
import dp;
import java.io.File;

public class DatalineSessionAdapter
  extends TimeAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "DatalineSessionAdapter";
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 7;
  private static final int i = 8;
  private static final int j = 9;
  private static final int k = 10;
  private static final int l = 11;
  private static final int m = 12;
  private static final int n = 13;
  private static final int o = 14;
  private static final int p = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new do(this);
  private LiteActivity jdField_a_of_type_ComDatalineActivitiesLiteActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  private int q = 0;
  private int r = 0;
  
  public DatalineSessionAdapter(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    int i1 = URLDrawableHelper.a();
    this.r = i1;
    this.q = i1;
    a();
  }
  
  private void a(GridView paramGridView)
  {
    int i1 = (SizeMeasure.e(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) - AIOUtils.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(i1);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(i1));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(ItemHolder paramItemHolder, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837584), paramInt1, paramInt2, false);
        Object localObject1 = ImageUtil.a(localBitmap, AIOUtils.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
        localObject3 = localObject1;
        if (localBitmap != null) {}
        localObject3 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localBitmap.recycle();
          localObject3 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = new ClipDrawable(new BitmapDrawable(localObject3), 48, 2);
          paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject2;
          break label102;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
      }
      label102:
      if (QLog.isColorLevel())
      {
        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
        localObject3 = localObject2;
      }
    }
    paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private void a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i1 = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    FileManagerUtil.a(paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.filename));
    paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362141);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362480);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362485);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362484);
        }
      }
      else
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362141);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362481);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362478);
        } else if (!paramDataLineMsgSet.issuc) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362485);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "%");
        }
      }
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i1);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ItemHolder paramItemHolder)
  {
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((Trans_entity)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
        {
          paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
          if (paramDataLineMsgRecord.msgtype == -1000) {
            break label232;
          }
        }
      }
    }
    label232:
    for (boolean bool = true;; bool = false)
    {
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout);
      if (paramDataLineMsgRecord.msgtype == -1000) {
        a(paramItemHolder, paramRelativeLayout, paramDataLineMsgRecord, paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a((int)paramDataLineMsgRecord.vipBubbleID, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() == 0);
  }
  
  private boolean a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      return true;
      if (paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        return false;
      }
    } while (paramDataLineMsgSet == null);
    int i1 = paramDataLineMsgSet.getCompletedCount();
    int i2 = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null))
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131362142)))) {
        break label540;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramItemHolder.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362141);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130839614);
      break;
      label492:
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130839614);
      break label128;
      label508:
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130839614);
      break label173;
      label524:
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130839614);
      break label218;
      label540:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131362132);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label578:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362481);
      } else if (i1 == i2) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + i2);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "/" + i2);
      }
    }
    label709:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i1 = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null)
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131362142)))) {
        break label332;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label126:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label370;
      }
      paramItemHolder.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label199:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label385;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label244:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label400;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362141);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label513;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130839614);
      break;
      label332:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131362132);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label126;
      label370:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label199;
      label385:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label244;
      label400:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362481);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362478);
      } else if (!paramDataLineMsgSet.issuc) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362485);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "%");
      }
    }
    label513:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i1);
  }
  
  private boolean b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return true;
    }
    if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int i1 = paramDataLineMsgSet.getCompletedCount();
    int i2 = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    dp localdp;
    label148:
    label313:
    if (i1 == i2)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + i2);
      i1 = ((Integer)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localdp = (dp)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localdp != null) {
        break label401;
      }
      localdp = new dp(this, paramItemHolder, paramDataLineMsgSet, i1, null);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localdp);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label455;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label421;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131362141);
      label227:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label487;
          }
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label502;
          }
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      return true;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(i1 + "/" + i2);
      break;
      label401:
      localdp.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localdp.jdField_a_of_type_ComDatalineUtilItemHolder = paramItemHolder;
      localdp.a();
      break label148;
      label421:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label227;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131362481);
      break label227;
      label455:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label227;
      label487:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label313;
      label502:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    int i1;
    label183:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramDataLineMsgSet == null);
        localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
      } while (localDataLineMsgRecord == null);
      i1 = URLDrawableHelper.a();
      this.r = i1;
      this.q = i1;
      if (!BaseBubbleBuilder.a) {
        paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.q, this.r);
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setMaxWidth(this.q);
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setMaxHeight(this.r);
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((localDataLineMsgRecord.path == null) || (!new File(localDataLineMsgRecord.path).exists())) {
        break;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label478;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label463;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131362112);
      if (paramDataLineMsgSet.isSendFromLocal()) {
        break label533;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (localDataLineMsgRecord.strMoloKey == null);
    label289:
    if ((localDataLineMsgRecord.strMoloSource != null) && (!localDataLineMsgRecord.strMoloSource.equals("")))
    {
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label550;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
      if (localDataLineMsgRecord.thumbPath != null)
      {
        paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label183;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label183;
      label463:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label289;
      label478:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        i1 = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i1);
        break label289;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label289;
      label533:
      break;
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label550:
    paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private void d(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramItemHolder);
    if ((paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getTime();
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    Object localObject = null;
    if (paramListView == null) {}
    label7:
    int i1;
    DataLineMsgSet localDataLineMsgSet;
    label242:
    do
    {
      float f1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
            } while (i1 == -1);
            paramListView = paramListView.getChildAt(i1 - paramListView.s());
          } while ((paramListView == null) || (i1 >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()));
          localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1);
          if (localDataLineMsgSet.mUpdateProcessTick == 0L) {}
          for (localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();; localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis())
          {
            if (!localDataLineMsgSet.isSingle()) {
              break label346;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramLong);
            if (localObject == null) {
              break;
            }
            f1 = paramFloat;
            if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
              f1 = ((DataLineMsgRecord)localObject).progress;
            }
            switch (((DataLineMsgRecord)localObject).msgtype)
            {
            default: 
              return;
            case -2335: 
            case -2009: 
            case -2005: 
              if (!((DataLineMsgRecord)localObject).bIsMoloImage) {
                break label242;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131297422);
              if (paramListView == null) {
                break label7;
              }
              paramListView.setProgress((int)(f1 * 100.0F));
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break label7;
              }
            }
          }
          localObject = (TextView)paramListView.findViewById(2131297406);
          paramListView = (ProgressBar)paramListView.findViewById(2131297407);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f1 * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f1 * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131297422);
      } while (paramListView == null);
      paramListView.setProgress((int)(f1 * 100.0F));
      return;
      paramListView = (ItemHolder)paramListView.getTag();
    } while (paramListView == null);
    label346:
    int i2;
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label406:
      i1 = localDataLineMsgSet.getCompletedCount();
      i2 = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i1 != i2) {
          break label506;
        }
        ((TextView)localObject).setText("" + i2);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i1 != i2) {
        break label540;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label406;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label406;
      label506:
      ((TextView)localObject).setText(i1 + "/" + i2);
    }
    label540:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.l, BaseChatItemLayout.i, BaseChatItemLayout.k, BaseChatItemLayout.j);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.i, BaseChatItemLayout.l, BaseChatItemLayout.j);
  }
  
  protected void a(ItemHolder paramItemHolder, View paramView, DataLineMsgRecord paramDataLineMsgRecord, BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null) {
      return;
    }
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramBubbleInfo = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramBubbleInfo.getColorStateList(2131427945);
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramBubbleInfo.getColorStateList(2131427944);; paramView = paramBubbleInfo.getColorStateList(2131427943))
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramBubbleInfo.getColorStateList(2131427942);
        break;
      }
    }
    if (paramBubbleInfo.e == 0) {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.f == 0)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131427943));
      return;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.e);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.f);
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (a()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
    if (i1 == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(i1 - paramListView.s());
    if (localView == null) {
      return false;
    }
    if (i1 >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) {
      return false;
    }
    paramListView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick != 0L) {
        break label130;
      }
    }
    for (paramListView.mUpdateMutiViewTick = System.currentTimeMillis(); paramListView.isSingle(); paramListView.mUpdateMutiViewTick = System.currentTimeMillis())
    {
      return true;
      label130:
      if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
        return true;
      }
    }
    localObject = (ItemHolder)localView.getTag();
    if (localObject == null) {
      return false;
    }
    switch (paramListView.getGroupType())
    {
    }
    do
    {
      do
      {
        do
        {
          d((ItemHolder)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((ItemHolder)localObject, paramListView));
        return false;
      } while (a((ItemHolder)localObject, paramListView));
      return false;
    } while (b((ItemHolder)localObject, paramListView));
    return false;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
  }
  
  public int getCount()
  {
    if (a()) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (a()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i1 = 1;
    if (a()) {
      paramInt = 13;
    }
    label121:
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      DataLineMsgSet localDataLineMsgSet;
      boolean bool;
      do
      {
        return paramInt;
        localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
        bool = localDataLineMsgSet.isSendFromLocal();
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          return 12;
        case -1000: 
          if (bool) {
            return 7;
          }
          return 0;
        case -2000: 
          if (!localDataLineMsgSet.isSingle()) {
            break label121;
          }
          paramInt = i1;
        }
      } while (!bool);
      return 8;
      if (bool) {
        return 9;
      }
      return 2;
      if (localDataLineMsgSet.isSingle())
      {
        if (bool) {
          return 10;
        }
        return 3;
      }
      if (bool) {
        return 11;
      }
      return 4;
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (!localDataLineMsgSet.isSingle()) {
        break;
      }
      paramInt = i1;
    } while (localDataLineMsgRecord.bIsMoloImage);
    return 5;
    if (localDataLineMsgRecord.bIsMoloImage) {
      return 2;
    }
    return 6;
    return 14;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (a())
    {
      if (paramView == null)
      {
        paramView = new ItemHolder();
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903258, null);
        ((View)localObject1).setTag(paramView);
        return localObject1;
      }
      paramViewGroup = (ItemHolder)paramView.getTag();
      return paramView;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
    if (localObject2 == null) {
      return null;
    }
    paramInt = getItemViewType(paramInt);
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject2).getFirstItem();
    if (paramView == null)
    {
      paramViewGroup = new ItemHolder();
      if (paramInt == 12)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903243, null);
        paramViewGroup.b((TextView)((View)localObject1).findViewById(2131297452));
        paramView = (View)localObject1;
        if (paramViewGroup.b() != null)
        {
          paramViewGroup.b().setText(2131362085);
          paramView = (View)localObject1;
        }
        label150:
        if (paramView == null) {
          break label2402;
        }
        paramView.setTag(paramViewGroup);
      }
    }
    label2326:
    label2402:
    for (;;)
    {
      if (paramViewGroup == null)
      {
        return null;
        if (paramInt == 14)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903234, null);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297202));
          paramView.setVisibility(4);
          paramView.setTag(paramViewGroup);
          break label150;
        }
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903244, null);
          label233:
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297440));
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          switch (paramInt)
          {
          }
        }
        for (;;)
        {
          paramViewGroup.a((ImageView)paramView.findViewById(2131297419));
          paramViewGroup.a((TextView)paramView.findViewById(2131297050));
          break;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903253, null);
          break label233;
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903254, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296554));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTag(paramViewGroup);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.a);
          if (((DataLineMsgSet)localObject2).isSendFromLocal()) {}
          for (localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427945);; localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427942))
          {
            paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
            paramViewGroup.a((ProgressBar)paramView.findViewById(2131297480));
            if (paramViewGroup.a() == null) {
              break;
            }
            paramViewGroup.a().setVisibility(8);
            break;
          }
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903235, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296300));
          paramViewGroup.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131297422));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297423));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297456));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297424));
          paramViewGroup.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297457));
          if (!((DataLineMsgSet)localObject2).isSendFromLocal())
          {
            paramViewGroup.a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297455));
            paramViewGroup.a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131297454));
            paramViewGroup.a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297453));
          }
          if (((DataLineMsgSet)localObject2).isSendFromLocal())
          {
            paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramViewGroup.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
            a(paramViewGroup, this.q, this.r);
          }
          for (;;)
          {
            paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.q, this.r);
            paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
            paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
            break;
            paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramViewGroup.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
          }
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903237, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297433));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131297432));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297407));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297456));
          paramViewGroup.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297457));
          if (!((DataLineMsgSet)localObject2).isSendFromLocal())
          {
            paramViewGroup.a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297455));
            paramViewGroup.a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131297454));
            paramViewGroup.a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297453));
          }
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTag(paramViewGroup);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
          a(paramViewGroup.a().jdField_a_of_type_AndroidWidgetGridView);
          continue;
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903230, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297402));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297403));
          paramViewGroup.a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297405));
          paramViewGroup.a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297406));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297407));
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130842125);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          continue;
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903228, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297402));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297403));
          paramViewGroup.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297404));
          paramViewGroup.a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297405));
          paramViewGroup.a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297406));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297407));
          paramViewGroup.a().e = ((TextView)paramView.findViewById(2131297455));
          paramViewGroup.a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131297454));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297453));
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130839613);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          continue;
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903236, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297426));
          paramViewGroup.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297427));
          paramViewGroup.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297428));
          paramViewGroup.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297429));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297403));
          paramViewGroup.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297404));
          paramViewGroup.a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297405));
          paramViewGroup.a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297406));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297407));
          paramViewGroup.a().e = ((TextView)paramView.findViewById(2131297455));
          paramViewGroup.a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131297454));
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131297453));
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130839614);
          paramViewGroup.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130839614);
          paramViewGroup.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130839614);
          paramViewGroup.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130839614);
          paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          paramViewGroup.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          paramViewGroup.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          paramViewGroup.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        }
        paramViewGroup = (ItemHolder)paramView.getTag();
        continue;
      }
      paramViewGroup.a((DataLineMsgSet)localObject2);
      localObject1 = paramView;
      if (paramInt == 12) {
        break;
      }
      if (paramInt == 14)
      {
        localObject1 = paramView;
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break;
        }
        localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqWidgetDateLineFrameLayout.getTag(2131296425);
        localObject1 = paramView;
        if (localObject2 == null) {
          break;
        }
        paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(paramInt));
        return paramView;
      }
      switch (paramInt)
      {
      case 4: 
      default: 
        a(localDataLineMsgRecord, paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject1 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqWidgetDateLineFrameLayout.getTag(2131296425);
          if (localObject1 != null)
          {
            paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject1).getBitmap());
            paramViewGroup.a().setTextColor(ColorStateList.valueOf(paramInt));
          }
        }
        if (a(((DataLineMsgSet)localObject2).getMsgId()))
        {
          localObject1 = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject2).getTime() * 1000L);
          paramViewGroup.a().setVisibility(0);
          paramViewGroup.a().setText((CharSequence)localObject1);
        }
        break;
      }
      for (;;)
      {
        d(paramViewGroup, (DataLineMsgSet)localObject2);
        return paramView;
        paramViewGroup.a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
        paramViewGroup.a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
        localObject1 = paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView;
        String str = AppConstants.Y;
        ((TextView)localObject1).setText(new QQText(localDataLineMsgRecord.msg, 13, 32, 6000));
        ((TextView)localObject1).setVisibility(0);
        if (paramViewGroup.a() != null)
        {
          if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
            break label2326;
          }
          paramViewGroup.a().setVisibility(0);
        }
        for (;;)
        {
          ((TextView)localObject1).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
          break;
          paramViewGroup.a().setVisibility(8);
        }
        c(paramViewGroup, (DataLineMsgSet)localObject2);
        break;
        b(paramViewGroup, (DataLineMsgSet)localObject2);
        break;
        a(paramViewGroup, (DataLineMsgSet)localObject2);
        break;
        b(paramViewGroup, (DataLineMsgSet)localObject2);
        break;
        a(paramViewGroup, (DataLineMsgSet)localObject2);
        break;
        paramViewGroup.a().setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    b();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter
 * JD-Core Version:    0.7.0.1
 */