package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.MagicFaceDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import fuw;
import fux;
import fuy;
import fvc;
import fvd;
import fve;
import fvf;
import fvg;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  public static long a = 0L;
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 1;
  public static final int m = 2;
  public static int n = 1;
  public EmojiManager a;
  MagicFaceDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonMagicFaceDownloadListener = new fuy(this);
  public PngFrameUtil a;
  fvf jdField_a_of_type_Fvf = new fuw(this);
  public List a;
  public Context b;
  public String b;
  public int o = 320;
  public int p = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "MarketFaceItemBuilder";
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)paramQQAppInterface.getManager(42));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil = new PngFrameUtil();
  }
  
  private URLDrawable a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder, Context paramContext)
  {
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b()) {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
        if (b(paramChatMessage))
        {
          paramHolder = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b();
          paramChatMessage = paramHolder;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig getSoundBigDrawable");
            paramChatMessage = paramHolder;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return paramChatMessage;
          paramHolder = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
          paramChatMessage = paramHolder;
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig sound getLoadingDrawable");
        return paramHolder;
        paramHolder = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(paramContext, BaseChatItemLayout.d);
        paramChatMessage = paramHolder;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig getBigDrawable");
      return paramHolder;
      int i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      if ((i1 != 1) && (i1 != 3) && (i1 != 4))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, 4)) {
          return paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
        }
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()) {
          return paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a();
        }
      }
      paramHolder = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(false);
      paramChatMessage = paramHolder;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| getLoadingDrawable local not exist");
    return paramHolder;
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonMagicFaceDownloadListener);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.jdField_d_of_type_Int != -1) {
        break label214;
      }
    }
    label214:
    for (localEmoticonPackage.rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);; localEmoticonPackage.rscType = paramHolder.jdField_d_of_type_Int)
    {
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      paramHolder.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramHolder);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localEmoticonPackage, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    URLDrawable localURLDrawable = a(paramChatMessage, paramHolder, this.jdField_b_of_type_AndroidContentContext);
    int i2;
    int i1;
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.j != 3))
    {
      i2 = localURLDrawable.getIntrinsicWidth();
      i1 = localURLDrawable.getIntrinsicHeight();
      i2 = (i2 * this.p + (this.o >> 1)) / this.o;
      i1 = (i1 * this.p + (this.o >> 1)) / this.o;
      paramHolder.e.setLayoutParams(new FrameLayout.LayoutParams(i2, i1));
      paramHolder.e.setImageDrawable(localURLDrawable);
      if (localURLDrawable != null) {}
      switch (localURLDrawable.getStatus())
      {
      default: 
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label160:
        paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        if ((paramChatMessage.isMarketFaceFlow) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0))
        {
          if (!paramChatMessage.isSend()) {
            break label580;
          }
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840719);
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramHolder, localURLDrawable);
      b(paramHolder);
      return;
      if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (localURLDrawable.getStatus() == 1)) {
        break;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width == 0)
      {
        i1 = 200;
        label273:
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height != 0) {
          break label384;
        }
      }
      label384:
      for (i2 = 200;; i2 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height)
      {
        int i3 = i1;
        if (i1 != i2) {
          i3 = i2;
        }
        i1 = (i3 * this.p + (this.o >> 1)) / this.o;
        i2 = (i2 * this.p + (this.o >> 1)) / this.o;
        paramHolder.e.setLayoutParams(new FrameLayout.LayoutParams(i1, i2));
        break;
        i1 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width;
        break label273;
      }
      if (!MagicfaceViewController.a()) {
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
      i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      boolean bool = SettingCloneUtil.readValue(this.jdField_b_of_type_AndroidContentContext, null, this.jdField_b_of_type_AndroidContentContext.getString(2131366260), "qqsetting_auto_receive_magic_face_key", true);
      if (((i1 == 1) || (i1 == 3) || (i1 == 4)) && (2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) && (((i1 != 3) && (i1 != 4)) || (bool))) {
        break label160;
      }
      float f1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      if ((f1 >= 0.0F) && (1.0F != f1)) {
        break label160;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label160;
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
      break label160;
      label580:
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840719);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_Boolean = false;
    if ((2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!MagicfaceViewController.a())) {}
    do
    {
      int i1;
      boolean bool;
      do
      {
        return;
        i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) {
          break;
        }
        if ((i1 != 1) && (i1 != 3) && (i1 != 4))
        {
          paramHolder.f.setVisibility(8);
          return;
        }
        bool = SettingCloneUtil.readValue(this.jdField_b_of_type_AndroidContentContext, null, this.jdField_b_of_type_AndroidContentContext.getString(2131366260), "qqsetting_auto_receive_magic_face_key", true);
      } while (((i1 == 3) || (i1 == 4)) && ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false))) || (-1.0F != this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonMagicFaceDownloadListener);
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      ((EmoticonPackage)localObject).jobType = 3;
      ((EmoticonPackage)localObject).rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);
      ((EmoticonPackage)localObject).type = 1;
      ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      this.jdField_a_of_type_JavaUtilList.add(paramHolder);
      paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
      return;
      paramHolder.f.setImageResource(2130837559);
      paramHolder.f.setVisibility(0);
    } while (!((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay);
    ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    Object localObject = new Emoticon();
    ((Emoticon)localObject).eId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId;
    ((Emoticon)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
    ((Emoticon)localObject).magicValue = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue;
    ((Emoticon)localObject).jobType = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType;
    ((ChatActivity)this.jdField_b_of_type_AndroidContentContext).a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    paramViewHolder = (MarketFaceItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localImageView.setId(2131296352);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131296322);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131296322);
      paramView.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      localImageView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131296356);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296352);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new fvg(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject2 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131296351);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131296356);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131296356);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 10;
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((ImageView)localObject3).setOnClickListener(this);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject4).setId(2131296353);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131296356);
      ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131296356);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      paramView.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131296354);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131296356);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131296356);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = (-AIOUtils.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = (-AIOUtils.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramView.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
      ((ProgressBar)localObject6).setId(2131296320);
      ((ProgressBar)localObject6).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130838130));
      int i1 = AIOUtils.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i1, i1);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject6, localLayoutParams);
      paramViewHolder.e = paramOnLongClickAndTouchListener;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView = localImageView;
      paramViewHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
      paramViewHolder.f = ((ImageView)localObject5);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject6);
    }
    long l1;
    for (;;)
    {
      if ((a(paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("表情发送失败");
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = EmoticonUtils.a(paramBaseChatItemLayout.mMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      l1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
      paramViewHolder.jdField_a_of_type_Long = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) {
        break;
      }
      paramViewHolder.e.setImageResource(2130837554);
      return paramView;
      paramViewHolder.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      if ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramViewHolder.jdField_b_of_type_AndroidWidgetImageView != null) && ((paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840753);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
    }
    if (2 != paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType)
    {
      a(paramChatMessage, paramViewHolder);
      return paramView;
    }
    paramBaseChatItemLayout = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
    boolean bool = false;
    if (paramViewHolder.jdField_b_of_type_Int == paramViewHolder.jdField_c_of_type_Int - 1) {
      bool = paramBaseChatItemLayout.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramBaseChatItemLayout.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue, paramViewHolder, l1, bool, true, new fux(this, paramChatMessage, paramViewHolder));
    paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramChatMessage.isMarketFaceFlow) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0))
    {
      if (!paramChatMessage.isSend()) {
        break label977;
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.f.setVisibility(8);
      b(paramViewHolder);
      return paramView;
      label977:
      paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840719);
      paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MarketFaceItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    Object localObject;
    int i1;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      localObject = (MessageForMarketFace)paramChatMessage;
      if (((MessageForMarketFace)localObject).mMarkFaceMessage != null)
      {
        paramChatMessage = EmosmUtils.bytes2eId(((MessageForMarketFace)localObject).mMarkFaceMessage.sbufID, ((MessageForMarketFace)localObject).mMarkFaceMessage.mediaType);
        i1 = ((MessageForMarketFace)localObject).mMarkFaceMessage.dwTabID;
        localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
        if (localObject == null) {
          break label122;
        }
      }
    }
    label122:
    for (paramChatMessage = ((EmoticonManager)localObject).a(String.valueOf(i1), paramChatMessage);; paramChatMessage = null)
    {
      if ((paramChatMessage != null) && (paramChatMessage.name != null)) {}
      for (paramChatMessage = paramChatMessage.name;; paramChatMessage = "") {
        return "发送了商城表情" + paramChatMessage;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131302479) {
      ChatActivityFacade.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    do
    {
      return;
      if (paramInt == 2131296306)
      {
        paramContext = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
        EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
        paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131368473));
        paramContext.show();
        paramChatMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        if ((paramChatMessage != null) && (paramChatMessage.name != null) && ((paramChatMessage.mobileFeetype != 0) || (paramChatMessage.downloadCount != 0)))
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          i1 = (int)(System.currentTimeMillis() / 1000L);
          if ((i1 - paramInt > 86400) || (i1 < paramInt))
          {
            this.jdField_a_of_type_Fvf.a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.jdField_c_of_type_Int, this.jdField_a_of_type_Fvf);
            return;
          }
          EmoticonUtils.a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
        this.jdField_a_of_type_Fvf.a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.jdField_c_of_type_Int, this.jdField_a_of_type_Fvf);
        return;
      }
    } while ((paramInt != 2131296307) && (paramInt != 2131296308));
    int i1 = 0;
    paramContext = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
    if (paramInt == 2131296307)
    {
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131368647, 0);
        return;
      }
      n = 1;
      EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      i1 = 7;
      paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131368474));
    }
    for (;;)
    {
      paramContext.show();
      if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId) != null) {
        break;
      }
      this.jdField_a_of_type_Fvf.a(i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.jdField_c_of_type_Int, this.jdField_a_of_type_Fvf);
      return;
      if (paramInt == 2131296308)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
        {
          ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131363814, 0);
          return;
        }
        paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131368475));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "");
        i1 = 107;
      }
    }
    EmoticonUtils.a(i1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected void a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131366317);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131366318);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new fvc(this, paramView), new fvd(this)).show();
      return;
      paramView = paramView.e.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.f.setVisibility(8);
    String str = paramURLDrawable.getURL().getHost();
    int i1 = paramURLDrawable.getStatus();
    if ("aio_preview".equals(str)) {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a())
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840753);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((i1 != 1) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.j != 3));
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837556);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        if (!"big_img".equals(str)) {
          break;
        }
        paramURLDrawable = paramURLDrawable.getHeader("image_dl_extra_info");
      } while ((paramURLDrawable == null) || (!Boolean.TRUE.toString().equals(paramURLDrawable.getValue())) || (i1 == 1));
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a())
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840753);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837556);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    } while (!"big_sound".equals(str));
    if (b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130968728);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      paramURLDrawable.start();
      return;
    }
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840753);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.a == null) || (paramPicEmoticonInfo.a.epId == null)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getString(2131368470));
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131368471), 1);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131368472), 1);
    localActionSheet.e(2131365736);
    localActionSheet.a(new fve(this, paramPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
    localActionSheet.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840753);
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
      paramXListView.e.setImageDrawable(paramView);
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null)) {
      return false;
    }
    if ((paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramAudioPlayer.a(EmosmUtils.getEmoticonSoundPath(paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId))))
    {
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b();
      paramXListView.e.setImageDrawable(paramView);
      PicEmoticonInfo.a(paramView);
      paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130968728);
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      paramView.start();
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 1)
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
      jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localQQCustomMenu.a(2131296306, this.jdField_b_of_type_AndroidContentContext.getString(2131368328));
      localQQCustomMenu.a(2131296307, this.jdField_b_of_type_AndroidContentContext.getString(2131367595));
      if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2) {
        localQQCustomMenu.a(2131296308, this.jdField_b_of_type_AndroidContentContext.getString(2131368327));
      }
      EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    if (super.a()) {}
    Object localObject1;
    do
    {
      return;
      if (paramView.getId() != 2131296356) {
        break;
      }
      paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      localObject1 = paramView.e.getDrawable();
    } while (!(localObject1 instanceof URLDrawable));
    Object localObject2 = (URLDrawable)localObject1;
    Object localObject3 = ((URLDrawable)localObject2).getURL().getHost();
    switch (((URLDrawable)localObject1).getStatus())
    {
    }
    for (;;)
    {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) && (MagicfaceViewController.a())) {
        a(paramView);
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 0) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2)) || ((((URLDrawable)localObject1).getStatus() != 1) && (!paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()))) {
        break;
      }
      localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      if ((((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b((String)localObject1) == null) && (!EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1))) {
        break label643;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (localObject2 == null) {
        break;
      }
      ((Handler)localObject2).obtainMessage(22, localObject1).sendToTarget();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_aio_pkg_tab", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, (String)localObject1, "", "");
      return;
      ((URLDrawable)localObject2).restartDownload();
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "msgOnclickListener| urldrawable restartDownload status=" + ((URLDrawable)localObject2).getStatus());
      }
      a(paramView, (URLDrawable)localObject2);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && ("big_sound".equals(localObject3)))
      {
        jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
        continue;
        if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 0) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2))
        {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          if ("big_sound".equals(localObject3))
          {
            if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.isSound)) {
              if (b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
              } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366443, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
              } else {
                MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              }
            }
          }
          else if ("aio_preview".equals(localObject3))
          {
            localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
            if (localObject2 != null)
            {
              paramView.e.setImageDrawable((Drawable)localObject2);
              paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              a(paramView, (URLDrawable)localObject2);
              if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
                jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
              }
            }
          }
        }
      }
    }
    label643:
    jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ep_detail_aio", 0);
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), false);
    return;
    if (paramView.getId() == 2131296351)
    {
      localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      if ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.isSound))
      {
        if (!b(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
          break label782;
        }
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    label782:
    do
    {
      do
      {
        for (;;)
        {
          super.onClick(paramView);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366443, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
          }
          else
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
            continue;
            if ((paramView.getId() != 2131296353) && (paramView.getId() != 2131296352)) {
              break;
            }
            localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
            localObject2 = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
            ((QQProgressDialog)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131368475));
            ((QQProgressDialog)localObject2).show();
            localObject3 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow", 0, 0, "", ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId, "", "");
            if (localObject3 == null)
            {
              this.jdField_a_of_type_Fvf.a(107, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, (QQProgressDialog)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.jdField_c_of_type_Int, this.jdField_a_of_type_Fvf);
            }
            else
            {
              EmoticonUtils.a(107, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, (QQProgressDialog)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
          }
        }
      } while (paramView.getId() != 2131296354);
      localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    } while ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (2 != ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType));
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonMagicFaceDownloadListener);
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      ((EmoticonPackage)localObject2).jobType = 3;
      ((EmoticonPackage)localObject2).type = 1;
      ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
      ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      ((MarketFaceItemBuilder.Holder)localObject1).f.setVisibility(8);
      ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject2, false);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
      break;
      ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = EmoticonUtils.a(((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ChatActivity)this.jdField_b_of_type_AndroidContentContext).a().a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, 1, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */