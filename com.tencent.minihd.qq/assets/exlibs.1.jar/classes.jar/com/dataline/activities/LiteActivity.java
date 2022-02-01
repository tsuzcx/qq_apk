package com.dataline.activities;

import aa;
import al;
import am;
import an;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ap;
import at;
import au;
import av;
import aw;
import ax;
import ay;
import az;
import ba;
import bb;
import bc;
import bd;
import be;
import bf;
import bg;
import bh;
import bm;
import bn;
import bo;
import bq;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.dataline.util.ItemHolder.FileItemHolder;
import com.dataline.util.ItemHolder.ImageItemHolder;
import com.dataline.util.ItemHolder.MutiImageItemHolder;
import com.dataline.util.ItemHolder.TextItemHolder;
import com.dataline.util.file.FileUtil;
import com.dataline.util.file.SendInfo;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardOperations.CancelCallback;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.DateLineFrameLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import r;
import s;
import t;
import u;
import v;
import w;
import x;
import y;
import z;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, ForwardOperations.CancelCallback, Observer
{
  public static final int a = 5242880;
  public static String a;
  public static final int b = 0;
  public static final String b = "dataline_text_cache";
  public static final int c = 1;
  public static final String c = "key_text";
  public static final int d = 2;
  public static final String d = "dataline_share_finish";
  public static final int e = 3;
  private static final String jdField_e_of_type_JavaLangString = "LASTFROM";
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 101;
  public static final int m = 102;
  public static final int n = 103;
  static final int o = 55;
  private static int q = 0;
  long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bg(this);
  private View jdField_a_of_type_AndroidViewView;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bh(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bo jdField_a_of_type_Bo;
  private LiteActivity.LiteJumpAction jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
  private DatalineSessionAdapter jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = null;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new aa(this);
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
  private FastImagePreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new aw(this);
  public DateLineFrameLayout a;
  public ScrollerRunnable a;
  public BubblePopupWindow a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public Runnable a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public View.OnClickListener b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean jdField_e_of_type_Boolean;
  private int p;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.e = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new v(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new w(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new at(this);
    this.jdField_a_of_type_JavaLangRunnable = new ay(this);
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130837979);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          i1 = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (i1 != 48)) {
            return paramContext.getResources().getDrawable(2130837979);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label156;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          i1 = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(i1);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          paramString.printStackTrace();
        }
        return paramContext.getResources().getDrawable(2130841763);
      }
      label156:
      int i1 = 119;
      Bitmap localBitmap = null;
    }
  }
  
  private DataLineMsgRecord a(DataLineHandler paramDataLineHandler, SendInfo paramSendInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramDataLineHandler = new DataLineMsgRecord();
    String str1 = paramSendInfo.a();
    String str2 = paramSendInfo.b();
    paramDataLineHandler.sessionid = paramSendInfo.a();
    paramDataLineHandler.path = str1;
    paramDataLineHandler.thumbPath = str2;
    paramDataLineHandler.msgtype = DataLineHandler.c(paramInt1);
    paramDataLineHandler.groupId = paramInt2;
    paramDataLineHandler.groupSize = paramInt3;
    paramDataLineHandler.groupIndex = paramInt4;
    return paramDataLineHandler;
  }
  
  private String a()
  {
    return getSharedPreferences("dataline_text_cache", 0).getString("key_text", "");
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(getString(2131366996));
    String str2 = getString(2131363684);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new bf(this, paramLong, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  public static void a(Context paramContext)
  {
    t localt = new t();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131367300), paramContext.getString(2131362124), 2131362047, 2131362047, localt, null).show();
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent = null;
    if (paramBoolean) {
      PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", PlusPanelUtils.b).commit();
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.c(this, paramIntent);
    ImageUtil.a(this, paramIntent);
    if (paramIntent != null)
    {
      if (!FileUtils.e(paramIntent))
      {
        QQToast.a(this, getString(2131367034), 0).b(getTitleBarHeight());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(this, getString(2131367035), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this, getString(2131367035), 0).b(getTitleBarHeight());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(this, CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(AlbumConstants.i, 55);
    ((Intent)localObject).putExtra("uin", AppConstants.Y);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.leftView.getText().toString());
    if (paramBoolean)
    {
      ((Intent)localObject).putExtra("uintype", 7);
      ((Intent)localObject).putExtra("callFromFastImage", true);
    }
    startActivity((Intent)localObject);
  }
  
  private void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(getActivity()))
    {
      FMToastUtil.a(2131367136);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    Object localObject1;
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 5242880L)) {
      localObject1 = getString(2131362465);
    }
    label80:
    int i1;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131362056);
        localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
        ((ActionSheet)localObject2).a((CharSequence)localObject1);
        ((ActionSheet)localObject2).a(getResources().getString(2131362422), 1);
        ((ActionSheet)localObject2).e(2131365736);
        ((ActionSheet)localObject2).a(new x(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject1 = getString(2131362057);
        }
        else
        {
          localObject1 = localObject2;
          if (localDataLineMsgSet.getGroupType() == -2000)
          {
            localObject1 = localObject2;
            if (!localDataLineMsgSet.isSingle())
            {
              localObject1 = localDataLineMsgSet.values().iterator();
              i1 = 0;
              label202:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label261;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    }
    label261:
    for (;;)
    {
      break label202;
      localObject1 = String.format(getString(2131362148), new Object[] { Integer.valueOf(i1) });
      break;
      break label80;
    }
  }
  
  private static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131297400);
    if (ThemeUtil.isInNightMode(paramIphoneTitleBarActivity.app)) {
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    while (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  public static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup)
  {
    int i1 = 0;
    SharedPreferences localSharedPreferences = paramIphoneTitleBarActivity.getSharedPreferences("chat_background_path_" + paramIphoneTitleBarActivity.app.a(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.Y;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int i2 = arrayOfString.length;
    for (;;)
    {
      if (i1 >= i2) {
        break label207;
      }
      String str = localSharedPreferences.getString(arrayOfString[i1], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
        if (!new File(str).exists())
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, "null");
          return;
        }
        if (a(paramIphoneTitleBarActivity, paramViewGroup, str)) {
          break;
        }
      }
      i1 += 1;
    }
    label207:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    paramContext = FileUtil.b(paramContext, paramString);
    ((DataLineHandler)paramQQAppInterface.a(8)).a(paramString, paramContext, 1, 0L, 0, 0, 0, false);
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.b(paramMessage))) {
      return;
    }
    Intent localIntent = this.app.a(this, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    runOnUiThread(new ax(this, paramMessage, localIntent));
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.postDelayed(new al(paramXListView, paramScrollerRunnable), 200L);
    }
  }
  
  public static void a(XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.setSelection(paramXListView.b());
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 3478)
    {
      QQToast.a(this, "字数超出限制", 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.a(8)).a(paramString);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (!a()) {
      b(null);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      localDataLineMsgRecord = this.app.a().a().b(paramLong);
    } while (localDataLineMsgRecord == null);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.a().a().a(paramLong);
      a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 1, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 2, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
    }
  }
  
  private void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultipleFile paths is null !!!!!!");
      }
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i1 += 1;
      }
    }
    Object localObject = new bm(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l1 = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l1 += new File(str).length();
      }
    }
    if (l1 == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.f(this)) && (!NetworkUtil.g(this)) && (l1 > 5242880L))
    {
      paramArrayList = new bn(this, (AsyncTask)localObject, paramInt);
      localObject = new s(this);
      DialogUtil.a(getActivity(), 230, getString(2131362060), getString(2131362061), 2131365736, 2131362063, paramArrayList, (DialogInterface.OnClickListener)localObject).show();
      return;
    }
    ((AsyncTask)localObject).execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    g();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      DataLineMsgSet localDataLineMsgSet = this.app.a().a(paramObservable.sessionid);
      if (QLog.isDevelopLevel()) {
        QLog.d("AutoTest_Xandy", 4, "SessionID:" + paramObservable.sessionid + ", Show:" + System.currentTimeMillis());
      }
      if ((DataLineMsgSet.isSingle(paramObservable)) || (localDataLineMsgSet == null) || (localDataLineMsgSet.getComeCount() <= 1)) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    label134:
    label253:
    do
    {
      break label134;
      for (;;)
      {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          if ((!paramObservable.isSendFromLocal()) && (paramObservable.msgtype != -1004)) {
            break label253;
          }
        }
        return;
        if (!this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(paramObservable.sessionid, this.jdField_a_of_type_ComTencentWidgetXListView))
        {
          this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
          continue;
          if ((paramObject instanceof QQMessageFacade.Message))
          {
            paramObservable = (QQMessageFacade.Message)paramObject;
            if (paramObservable.frienduin == null) {
              break;
            }
            if (!paramObservable.frienduin.endsWith(String.valueOf(AppConstants.Y))) {
              continue;
            }
            this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            continue;
          }
          if ((paramObject instanceof RecentUser))
          {
            paramObservable = (RecentUser)paramObject;
            if (paramObservable.uin == null) {
              break;
            }
            if (paramObservable.uin.endsWith(String.valueOf(AppConstants.Y))) {
              this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            }
          }
        }
      }
      paramObject = (HotChatManager)this.app.getManager(58);
    } while ((paramObservable.isread) || (paramObject.d(paramObservable.frienduin)));
    a(this.app.a().a());
  }
  
  private boolean a()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(9);
    return (localRegisterProxySvcPackHandler.a() == 0) || (localRegisterProxySvcPackHandler.e() != 0);
  }
  
  private boolean a(Intent paramIntent, int paramInt)
  {
    paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (paramInt == 101) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent = a(paramIntent, bool);
      if (paramIntent == null) {
        break;
      }
      ((DataLineHandler)this.app.a(8)).a(paramIntent, false);
      return true;
    }
    return false;
  }
  
  private static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    Object localObject = (String)paramViewGroup.getTag(2131296424);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if (!"null".equals(localObject))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131296424, "null");
      }
    }
    for (;;)
    {
      return true;
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131296424, "null");
      }
      else if (!paramString.equals(localObject))
      {
        localObject = BitmapManager.a(paramString);
        if (localObject == null) {
          break;
        }
        localObject = new ChatBackgroundDrawable(paramIphoneTitleBarActivity.getResources(), (Bitmap)localObject);
        paramViewGroup.setBackgroundDrawable((Drawable)localObject);
        paramViewGroup.setTag(2131296424, paramString);
        paramViewGroup.setTag(2131296425, localObject);
        a(paramIphoneTitleBarActivity);
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      do
      {
        return true;
        paramQQAppInterface = paramQQAppInterface.a().a(paramLong);
      } while (paramQQAppInterface == null);
      if ((paramQQAppInterface.cloudType != 2) && (paramQQAppInterface.status == 1)) {
        return false;
      }
      if (paramQQAppInterface.nOpType != 6) {
        return false;
      }
    } while (paramQQAppInterface.status != 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    return a(paramQQAppInterface, paramDataLineMsgRecord.nWeiyunSessionId);
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
    }
  }
  
  private void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.e(getActivity()))
    {
      FMToastUtil.a(2131367136);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 5242880L)) {}
    for (paramItemHolder = getString(2131362466);; paramItemHolder = "")
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = localDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
        {
          localDataLineMsgRecord.bIsResendOrRecvFile = true;
          localDataLineMsgRecord.fileMsgStatus = 0L;
          localDataLineMsgRecord.progress = 0.0F;
          localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
      {
        int i1 = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramItemHolder = String.format(getString(2131362150), new Object[] { Integer.valueOf(i1) });; paramItemHolder = String.format(getString(2131362149), new Object[] { Integer.valueOf(i1) }))
        {
          localObject = new y(this);
          DialogUtil.a(this, 230, getString(2131362060), paramItemHolder, 2131365737, 2131365737, null, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
      }
      localObject = paramItemHolder;
      if (paramItemHolder.equals(""))
      {
        localObject = paramItemHolder;
        if (localDataLineMsgSet.getGroupType() == -2000)
        {
          localObject = paramItemHolder;
          if (!localDataLineMsgSet.isSingle()) {
            localObject = String.format(getString(2131362147), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramItemHolder = (ItemHolder)localObject;
      if (((String)localObject).equals("")) {
        paramItemHolder = getString(2131362059);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      ((ActionSheet)localObject).a(paramItemHolder);
      ((ActionSheet)localObject).a(getResources().getString(2131362421), 1);
      ((ActionSheet)localObject).e(2131365736);
      ((ActionSheet)localObject).a(new z(this, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
  }
  
  private static void b(ScrollerRunnable paramScrollerRunnable, XListView paramXListView, int paramInt)
  {
    if (paramXListView != null) {}
    try
    {
      paramScrollerRunnable.a(paramInt, -1, null);
      paramXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
    catch (IllegalArgumentException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
  }
  
  private void b(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.msgtype = -2334;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList(localDataLineMsgRecord);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  private void b(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    DataLineHandler localDataLineHandler;
    int i2;
    int i1;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.app.a(8);
      i2 = paramArrayList.size();
      if (i2 > 3) {
        break;
      }
      i1 = 0;
      while (i1 < i2)
      {
        localObject = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i1 += 1;
      }
    }
    label110:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((i2 > 3) && (i2 < 50))
    {
      localObject = new ArrayList();
      int i3 = localDataLineHandler.a();
      i1 = 0;
      if (i1 < i2)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, i3, i2, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, i3)) {
          break label385;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label385:
    for (;;)
    {
      i1 += 1;
      break label110;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      i2 = localDataLineHandler.a();
      i1 = 0;
      label245:
      if (i1 < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, i2, 50, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, i2)) {
          break label382;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      label382:
      for (;;)
      {
        i1 += 1;
        break label245;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i1 = 0;
        while (i1 < 50)
        {
          paramArrayList.remove(0);
          i1 += 1;
        }
        break;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetDateLineFrameLayout.a();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    for (long l1 = 200L;; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "delay is:" + l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ba(this, bool, paramBoolean), l1);
      return;
    }
  }
  
  private boolean b()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      k();
      return false;
    }
    if (new StatFs(AppConstants.aE).getAvailableBlocks() <= 1)
    {
      j();
      return false;
    }
    return true;
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent.hasExtra("JumpAction.Text"))
    {
      paramIntent = paramIntent.getStringExtra("JumpAction.Text");
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        c(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
          d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837573);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramIntent.length());
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.d) || ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)) || ((!paramBoolean) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 8))) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i1 });
    localValueAnimator.setDuration(150L);
    View localView = findViewById(2131297395);
    localValueAnimator.addUpdateListener(new bb(this, localView, paramBoolean, i1));
    localValueAnimator.addListener(new bd(this, paramBoolean, localView));
    localValueAnimator.start();
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("dataline_text_cache", 0);
    Editable localEditable = null;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    }
    Object localObject = localEditable;
    if (localEditable == null) {
      localObject = "";
    }
    localSharedPreferences.edit().putString("key_text", ((CharSequence)localObject).toString()).commit();
  }
  
  private void d(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i1 == -1) {
      label14:
      return;
    }
    long l1 = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (i1 != 100) {
        break label1388;
      }
    }
    label210:
    label1380:
    label1383:
    label1388:
    for (int i3 = 0;; i3 = 1)
    {
      Object localObject1 = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      Object localObject6;
      Object localObject5;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject6 = paramIntent.getExtras();
        localObject5 = null;
        localObject1 = localObject5;
        if (localObject6 != null)
        {
          localObject6 = ((Bundle)localObject6).getParcelableArrayList("fileinfo_array");
          localObject1 = localObject5;
          if (localObject6 == null) {}
        }
        try
        {
          localObject1 = (ArrayList)localObject6;
          if (localObject1 == null)
          {
            l();
            return;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            localObject2 = null;
          }
          localObject5 = new ArrayList();
          localObject6 = (DataLineHandler)this.app.a(8);
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = a((ForwardFileInfo)((Iterator)localObject2).next(), false);
            if (localDataLineMsgRecord != null) {
              ((ArrayList)localObject5).add(localDataLineMsgRecord);
            }
          }
          if (((ArrayList)localObject5).size() <= 0) {
            break label317;
          }
        }
        ((DataLineHandler)localObject6).a((ArrayList)localObject5, false);
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        boolean bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
        if ((!this.jdField_a_of_type_Boolean) || (bool)) {
          break;
        }
        paramIntent = paramIntent.getExtras();
        localObject2 = paramIntent.getString("app_name");
        if (l1 != 0L) {
          break label1380;
        }
        paramIntent = StructMsgFactory.a(paramIntent);
        if ((paramIntent == null) || (!(paramIntent instanceof AbsShareMsg))) {
          break label1383;
        }
      }
      for (paramIntent = (AbsShareMsg)paramIntent;; paramIntent = null)
      {
        if (paramIntent != null) {
          l1 = paramIntent.mSourceAppid;
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              a(l1, (String)localObject2);
              return;
              l();
              break label210;
              localObject5 = ((ArrayList)localObject2).iterator();
              int i2;
              for (i1 = 0; ((Iterator)localObject5).hasNext(); i1 = i2)
              {
                localObject6 = (String)((Iterator)localObject5).next();
                if (localObject6 != null)
                {
                  i2 = i1;
                  if (!((String)localObject6).equals("/")) {}
                }
                else
                {
                  i2 = i1;
                  if (i1 == 0)
                  {
                    i2 = 1;
                    l();
                  }
                  ((Iterator)localObject5).remove();
                }
              }
              if (!((ArrayList)localObject2).isEmpty())
              {
                a((ArrayList)localObject2, i3);
                break label210;
              }
              if (i1 != 0) {
                break label210;
              }
              l();
              break label210;
              localObject5 = new ArrayList();
              if (a(paramIntent, i1)) {
                break;
              }
              switch (i1)
              {
              default: 
                StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_other");
                break;
              case 101: 
                StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_image");
                localObject2 = paramIntent.getStringExtra("dataline_forward_path");
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label14;
                }
                localObject6 = ((String)localObject2).split(";");
                ((ArrayList)localObject5).clear();
                i1 = 0;
                if (i1 < localObject6.length) {
                  try
                  {
                    localObject2 = URLDecoder.decode(localObject6[i1], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
                      {
                        a((String)localObject2);
                        ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                        }
                        i1 += 1;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException paramIntent)
                  {
                    if (!QLog.isColorLevel()) {
                      break label14;
                    }
                    QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i1]);
                    return;
                  }
                  catch (IllegalArgumentException localIllegalArgumentException1)
                  {
                    for (;;)
                    {
                      localObject3 = localObject6[i1];
                      continue;
                      ((ArrayList)localObject5).add(localObject3);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject3);
                      }
                    }
                  }
                }
                break;
              }
            }
            if (((ArrayList)localObject5).isEmpty()) {
              break label210;
            }
            a((ArrayList)localObject5, 1);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break label210;
            }
            if (((ArrayList)localObject5).size() > 1)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (!QLog.isColorLevel()) {
                break label210;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              break label210;
            }
            if (((ArrayList)localObject5).size() != 1) {
              break label210;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label210;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
            break label210;
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_file");
            Object localObject3 = paramIntent.getStringExtra("dataline_forward_path");
            if ((localObject3 == null) || (((String)localObject3).equals("")))
            {
              l();
              return;
            }
            localObject6 = ((String)localObject3).split(";");
            ((ArrayList)localObject5).clear();
            i1 = 0;
            if (i1 < localObject6.length) {
              try
              {
                localObject3 = URLDecoder.decode(localObject6[i1], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                  {
                    a((String)localObject3);
                    i1 += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i1]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException2)
              {
                for (;;)
                {
                  localObject4 = localObject6[i1];
                  continue;
                  ((ArrayList)localObject5).add(localObject4);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + (String)localObject4);
                  }
                }
              }
            }
          }
          if (((ArrayList)localObject5).isEmpty()) {
            break label210;
          }
          switch (FileManagerUtil.a((String)((ArrayList)localObject5).get(0)))
          {
          default: 
            i1 = 0;
          }
          for (;;)
          {
            a((ArrayList)localObject5, i1);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
            break;
            i1 = 1;
            continue;
            i1 = 3;
            continue;
            i1 = 2;
          }
          Object localObject4 = paramIntent.getStringExtra("dataline_forward_text");
          if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
            break label210;
          }
          if (Patterns.b.matcher((CharSequence)localObject4).find()) {
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_link");
          }
          for (;;)
          {
            a((String)localObject4);
            break;
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_text");
          }
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "liteActivity onClick call removeFastImage");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(34);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
    }
  }
  
  private void e()
  {
    c(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      d(false);
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837573);
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXListView.getWindowToken(), 0);
  }
  
  private void e(Intent paramIntent)
  {
    if (this.leftView == null) {
      return;
    }
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131366025)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4recent");
      g();
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        this.c = paramIntent.getExtras().getBoolean("isBack2Root");
        paramIntent.getExtras().putBoolean("isBack2Root", false);
      }
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("LASTFROM");
        if (str != null)
        {
          this.leftView.setText(str);
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        }
      }
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        this.c = true;
        this.leftView.setText(getString(2131366025));
        this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        g();
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.c = true;
          this.leftView.setText(getString(2131366025));
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
          g();
        }
      }
      str = this.leftView.getText().toString();
      paramIntent = str;
      if (!getString(2131365114).equals(str)) {
        paramIntent = "返回" + str + "界面";
      }
      this.leftView.setContentDescription(paramIntent);
      return;
      if (str.contains(getString(2131366000))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4buddylist");
      } else if (str.contains(getString(2131362352))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_op4dongtai");
      }
    }
  }
  
  private void f()
  {
    int i2 = 8;
    int i3 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.p = ChatTextSizeSettingActivity.a(this);
    int i1 = i2;
    switch (i3)
    {
    default: 
      i1 = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(i1);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, this.p);
      return;
      i1 = 6;
      continue;
      i1 = 6;
    }
  }
  
  private void g()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((localObject == null) || (((String)localObject).startsWith(getString(2131366025)))) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      localObject = this.app.a();
    } while (localObject == null);
    int i1 = ((QQMessageFacade)localObject).e();
    if (i1 > 0)
    {
      if (i1 > 99)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131366025) + "(99+)");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131366025) + "(" + i1 + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131366025));
  }
  
  private void h()
  {
    setTitleBackground(2);
    setTitle(2131362046);
    ImageView localImageView = this.rightViewImg;
    if (localImageView != null)
    {
      localImageView.setContentDescription(getResources().getText(2131362064));
      localImageView.setVisibility(0);
      localImageView.setImageResource(2130841831);
      localImageView.setOnClickListener(new u(this));
      this.rightViewImg.setContentDescription("进入我的电脑高级设置界面");
      e(getIntent());
    }
  }
  
  private void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.a().a().b(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void j()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838220);
    localQQToast.c(2000);
    localQQToast.b(2131362081);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void k()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838220);
    localQQToast.c(2000);
    localQQToast.b(2131362082);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void l()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838220);
    localQQToast.c(2000);
    localQQToast.b(2131362107);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  private void m()
  {
    boolean bool = false;
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i1 = 0;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i2 = i1;
      for (;;)
      {
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
        if (!((DataLineMsgRecord)localIterator2.next()).isread) {
          i2 += 1;
        }
      }
    }
    if (i1 == 0) {
      bool = true;
    }
    b(bool);
  }
  
  private void n()
  {
    Object localObject = new ArrayList();
    au localau = new au(this, (List)localObject);
    av localav = new av(this);
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i4 = 0;
    int i3 = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i1 = 0;
      int i2 = i3;
      int i5 = i4;
      i4 = i5;
      i3 = i2;
      if (localIterator2.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label258;
        }
        i3 = i2;
        i4 = i1;
        if (i1 == 0)
        {
          i3 = i2 + 1;
          i4 = 1;
        }
        ((List)localObject).add(localDataLineMsgRecord);
        i5 += 1;
        i1 = i4;
        i2 = i3;
      }
    }
    label258:
    for (;;)
    {
      break;
      if (i3 >= 3)
      {
        localObject = String.format(getString(2131362137), new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        ((DataLineHandler)this.app.a(8)).a(115);
        DialogUtil.a(this, 230, getString(2131362060), (String)localObject, 2131365736, 2131362138, localau, localav).show();
      }
      return;
    }
  }
  
  private void o()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    if (paramForwardFileInfo == null) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = this.app.a().a(paramForwardFileInfo.b());
    int i3 = DataLineHandler.a(localFileManagerEntity);
    boolean bool = DataLineHandler.b(i3);
    int i2 = DataLineHandler.a(paramForwardFileInfo.d(), paramBoolean);
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "转发文件, name[" + paramForwardFileInfo.d() + "], LocalPath[" + paramForwardFileInfo.a() + "], FileSize[" + paramForwardFileInfo.d() + "], fileFrom[" + i3 + "], bSupportForward[" + bool + "], eFileType[" + i2 + "], " + paramForwardFileInfo.toString());
    }
    if (!bool) {
      return null;
    }
    int i1 = i2;
    if (!paramBoolean)
    {
      i1 = i2;
      if (i2 == 1) {
        i1 = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.c(i1);
    localDataLineMsgRecord.sessionid = 0L;
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = i3;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (localFileManagerEntity != null)
    {
      if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
        localDataLineMsgRecord.md5 = HexUtil.a(localFileManagerEntity.strFileMd5);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
        localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
      }
      if (!TextUtils.isEmpty(paramForwardFileInfo.a())) {
        break label348;
      }
    }
    label348:
    for (localDataLineMsgRecord.path = paramForwardFileInfo.d();; localDataLineMsgRecord.path = paramForwardFileInfo.a())
    {
      return localDataLineMsgRecord;
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(this.app.a());
      break;
    }
  }
  
  public void a()
  {
    Object localObject = new File(AppConstants.aG + "photo/");
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      QQToast.a(this, 2131367289, 0).a();
      return;
    }
    localObject = AppConstants.aG + "photo/" + System.currentTimeMillis() + ".jpg";
    Uri.fromFile(new File((String)localObject));
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", (String)localObject).commit();
    Intent localIntent = new Intent();
    FileProvider7Helper.setSystemCapture(this, new File((String)localObject), localIntent);
    com.tencent.mobileqq.app.BaseActivity.sNotShowLockScreen = true;
    startActivityForResult(localIntent, 5);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.app, paramIntent, paramIntent.getExtras());
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(String.valueOf(AppConstants.Y), -1, "", "我的电脑");
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a = this;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(a());
    if (55 == paramIntent.getIntExtra(AlbumConstants.i, -1)) {
      new bq(this, null).execute(new Intent[] { paramIntent });
    }
    if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
      getIntent().putExtra("isMigSdkShare", true);
    }
    d(paramIntent);
    c(paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    this.app.a().a().d();
    if (!paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ItemHolder localItemHolder = (ItemHolder)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = localItemHolder.a();
    String str1 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    Object localObject;
    String str2;
    if (localDataLineMsgSet.isSingle())
    {
      RelativeLayout localRelativeLayout;
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        localRelativeLayout = null;
      }
      while (localRelativeLayout == null)
      {
        return false;
        localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localQQCustomMenu.a(2131302491, paramView.getContext().getString(2131367603));
        localQQCustomMenu.a(2131298174, paramView.getContext().getString(2131367595));
        localQQCustomMenu.a(2131298924, paramView.getContext().getString(2131364620));
        continue;
        localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        str1 = localDataLineMsgRecord.path;
        continue;
        if (localDataLineMsgRecord.bIsMoloImage) {}
        for (localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;; localRelativeLayout = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout)
        {
          str1 = localDataLineMsgRecord.path;
          break;
        }
      }
      Context localContext = localRelativeLayout.getContext();
      localObject = localRelativeLayout;
      str2 = str1;
      if (FileUtils.b(str1))
      {
        localObject = localRelativeLayout;
        str2 = str1;
        if (localDataLineMsgRecord.strMoloKey == null)
        {
          localQQCustomMenu.a(2131298174, localContext.getString(2131362089));
          localObject = localRelativeLayout;
          str2 = str1;
          if (localDataLineMsgSet.getGroupType() == -2000)
          {
            localQQCustomMenu.a(2131298924, paramView.getContext().getString(2131364620));
            str2 = str1;
            localObject = localRelativeLayout;
          }
        }
      }
      paramView = ((RelativeLayout)localObject).getContext();
      localQQCustomMenu.a(2131302483, paramView.getString(2131362087));
      boolean bool1;
      if (localDataLineMsgSet.getGroupType() != -2000)
      {
        bool1 = bool2;
        if (localDataLineMsgSet.getGroupType() == -2335)
        {
          bool1 = bool2;
          if (!localDataLineMsgRecord.bIsMoloImage) {}
        }
      }
      else
      {
        bool1 = true;
      }
      paramView = new ap(this, localDataLineMsgRecord, localDataLineMsgSet, paramView, str2, bool1);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, localQQCustomMenu, paramView);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new am(this));
      return true;
    }
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramView = null;
    }
    for (;;)
    {
      localObject = paramView;
      str2 = str1;
      if (paramView != null) {
        break;
      }
      return false;
      paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      continue;
      if (localDataLineMsgRecord.bIsMoloImage) {
        paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      } else {
        paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
    }
  }
  
  public void b()
  {
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null)
    {
      l1 = getIntent().getIntExtra("req_share_id", 0);
      if (l1 != 0L) {
        break label78;
      }
      localObject = StructMsgFactory.a(getIntent().getExtras());
      if ((localObject == null) || (!(localObject instanceof AbsShareMsg))) {
        break label81;
      }
    }
    label78:
    label81:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      if (localObject != null) {
        l1 = ((AbsShareMsg)localObject).mSourceAppid;
      }
      for (;;)
      {
        if (l1 != 0L) {
          ForwardOperations.a(this, false, "sendToMyComputer", l1);
        }
        return;
      }
    }
  }
  
  protected void broadcastRecieve(Intent paramIntent)
  {
    a(paramIntent);
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra(AlbumConstants.i, 55);
    localIntent.putExtra("uin", AppConstants.Y);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.leftView.getText().toString());
    localIntent.getExtras().remove("forward_type");
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = getBaseContext().getSharedPreferences("album_file", 0);
    String str = ((SharedPreferences)localObject).getString("album_key_name", null);
    localObject = ((SharedPreferences)localObject).getString("album_key_id", null);
    localIntent.putExtra("ALBUM_NAME", str);
    localIntent.putExtra("ALBUM_ID", (String)localObject);
    startActivity(localIntent);
    AlbumUtil.a(this, false, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (!a()) {
      b(null);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        switch (paramInt1)
                        {
                        case 4: 
                        default: 
                          return;
                        }
                      } while ((paramInt2 != -1) || (paramIntent == null));
                      paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                    } while ((paramIntent == null) || (paramIntent.size() <= 0));
                    b(paramIntent, 1);
                    paramIntent.clear();
                    a(false);
                    return;
                  } while (paramInt2 != -1);
                  a(paramIntent, false);
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null));
                paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
              } while ((paramIntent == null) || (paramIntent.size() <= 0));
              b(paramIntent, 2);
              paramIntent.clear();
              a(false);
              return;
            } while (paramInt2 != -1);
            a(false);
            return;
          } while ((paramInt2 != -1) || (paramIntent == null));
          paramIntent = paramIntent.getExtras().getString("textMsg");
        } while (paramIntent.length() <= 0);
        a(paramIntent);
        return;
      } while (paramInt2 != -1);
      a(false);
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    return;
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427366);
    setContentView(2130903227);
    setTitle(2131362046);
    getWindow().setBackgroundDrawable(null);
    h();
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction = new LiteActivity.LiteJumpAction(this, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDateLineFrameLayout = ((DateLineFrameLayout)findViewById(2131297393));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDateLineFrameLayout.setTag(2131296424, "n/a");
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.app.a(ChatActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    paramBundle = this.app.a();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297394));
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    Object localObject1 = (DataLineHandler)this.app.a(8);
    ((DataLineHandler)localObject1).jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    paramBundle = this.app.a();
    if (paramBundle == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = new DatalineSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
      Object localObject2 = LayoutInflater.from(getActivity()).inflate(2130903177, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130840064));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)localObject2);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new r(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296723));
      localObject2 = getResources().getDrawable(2130841714);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131297399));
      int i2 = this.jdField_a_of_type_AndroidWidgetGridView.getNumColumns();
      int i1 = i2;
      if (i2 == -1) {
        i1 = 3;
      }
      int i3 = AIOUtils.a(104.0F, getResources());
      if (getResources().getConfiguration().orientation == 2)
      {
        i2 = SizeMeasure.e(this);
        i1 = i3 - (i2 - i3 * 2 - AIOUtils.a(56.0F, getResources()) * i1) / ((i1 - 1) * 2);
        this.jdField_a_of_type_AndroidWidgetGridView.setPadding(i1, 0, i1, 0);
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297030));
        this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
        this.jdField_a_of_type_Bo = new bo(this, null);
        this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Bo);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297037));
        localObject2 = Build.MODEL;
        if ((!"SH-02E".equals(localObject2)) && (!"SBM200SH".equals(localObject2))) {}
      }
      try
      {
        localObject2 = TextView.class.getDeclaredField("mTextSelectHandleRes");
        ((Field)localObject2).setAccessible(true);
        i1 = ((Integer)((Field)localObject2).get(new TextView(this))).intValue();
        ((Field)localObject2).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(i1));
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new an(this));
        f();
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bc(this));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297398));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131297397));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        o();
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.getCount());
        m();
        n();
        this.app.a().a().d();
        localObject2 = (RegisterProxySvcPackHandler)this.app.a(9);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new be(this), 200L);
        b(getIntent());
        if ((((RegisterProxySvcPackHandler)localObject2).a() == 0) && (!((RegisterProxySvcPackHandler)localObject2).a()))
        {
          ((RegisterProxySvcPackHandler)localObject2).a();
          ((RegisterProxySvcPackHandler)localObject2).a(true);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty())
        {
          localObject2 = getSharedPreferences("first_enter_dataline", 0);
          i1 = ((SharedPreferences)localObject2).getInt("year", -1);
          i2 = ((SharedPreferences)localObject2).getInt("month", -1);
          i3 = ((SharedPreferences)localObject2).getInt("day", -1);
          localObject3 = Calendar.getInstance();
          i4 = ((Calendar)localObject3).get(1);
          i5 = ((Calendar)localObject3).get(2);
          i6 = ((Calendar)localObject3).get(5);
          if ((i4 != i1) || (i5 != i2) || (i6 != i3))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() - 1);
            if (localObject3 != null)
            {
              localObject3 = ((DataLineMsgSet)localObject3).getFirstItem();
              if ((localObject3 != null) && (((DataLineMsgRecord)localObject3).msgtype != -5000) && (((DataLineMsgRecord)localObject3).msgtype != -1000))
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
                for (;;)
                {
                  if (((Iterator)localObject3).hasNext())
                  {
                    DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject3).next();
                    if (localDataLineMsgSet != null)
                    {
                      DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
                      if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.msgtype == -5000))
                      {
                        try
                        {
                          ((Iterator)localObject3).remove();
                          paramBundle.a(localDataLineMsgSet);
                        }
                        catch (Exception localException2)
                        {
                          localException2.printStackTrace();
                        }
                        continue;
                        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramBundle.a(true);
                        break;
                        i2 = SizeMeasure.b(this);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        int i4;
        int i5;
        int i6;
        for (;;)
        {
          localException1.printStackTrace();
        }
        localObject1 = ((DataLineHandler)localObject1).a(0);
        Object localObject3 = new DataLineMsgRecord();
        ((DataLineMsgRecord)localObject3).msgId = ((Long)localObject1).longValue();
        ((DataLineMsgRecord)localObject3).sessionid = ((Long)localObject1).longValue();
        ((DataLineMsgRecord)localObject3).msgtype = -5000;
        ((DataLineMsgRecord)localObject3).time = MessageCache.a();
        ((DataLineMsgRecord)localObject3).isread = true;
        paramBundle.a((DataLineMsgRecord)localObject3);
        paramBundle = localException1.edit();
        paramBundle.putInt("year", i4);
        paramBundle.putInt("month", i5);
        paramBundle.putInt("day", i6);
        paramBundle.commit();
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.app.a() != null)
    {
      this.app.a().a().d();
      if (q == 0)
      {
        this.app.a().a().c();
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    if (this.app.a() != null) {
      this.app.a().e();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    e(paramIntent);
    d();
    a(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    b(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((DataLineHandler)this.app.a(8)).d();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      d(true);
    }
    if ((this.jdField_a_of_type_Boolean) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetDateLineFrameLayout);
    q += 1;
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    q -= 1;
  }
  
  public void finish()
  {
    super.finish();
    d();
    ((DataLineHandler)this.app.a(8)).jdField_b_of_type_Boolean = false;
    i();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 2000L);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) {
        d(false);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a();
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 34), 5000L);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
        d(false);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0))
    {
      e();
      return true;
    }
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_a_of_type_Boolean) && (!bool))
    {
      long l1 = getIntent().getLongExtra("res_share_id", 0L);
      if (l1 > 0L) {
        ForwardOperations.a(this, true, "shareToQQ", AppShareIDUtil.b(l1));
      }
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      d(false);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    label305:
    Object localObject;
    switch (i1)
    {
    default: 
    case 2131297397: 
    case 2131297398: 
      do
      {
        return;
        boolean bool;
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 8)
        {
          bool = true;
          if (!bool) {
            break label305;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)LayoutInflater.from(getActivity()).inflate(2130903074, null));
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setBackgroundDrawable(getResources().getDrawable(2130837570));
            i1 = (int)(5.0F * this.mDensity);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setPadding(i1, i1, i1, i1 * 3);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(12);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(5.0F * this.mDensity + 0.5F));
            this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ((int)(246.0F * this.mDensity + 0.5F));
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131296443);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_AndroidOsHandler);
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.b();
        }
        for (;;)
        {
          b(bool);
          return;
          bool = false;
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
            d(false);
          }
        }
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      } while ((paramView == null) || (paramView.length() <= 0));
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_cktxt");
      localObject = AppConstants.Y;
      a(new QQText(paramView, 13, 32, 6000).toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    case 2131296329: 
      localObject = (Intent)paramView.getTag();
      if (((Intent)localObject).getExtras().getInt("uintype") == 0)
      {
        String str = ((Intent)localObject).getExtras().getString("uin");
        if (!ChatActivityUtils.a(this.app, str))
        {
          ((Intent)localObject).removeExtra("uintype");
          ((Intent)localObject).putExtra("uintype", 1003);
        }
      }
      ((Intent)localObject).putExtra("message_box_click", true);
      MediaPlayerManager.a(this.app).a(false);
      startActivity((Intent)localObject);
      paramView.setVisibility(8);
      finish();
      return;
    }
    a(null, true);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramObservable, paramObject);
      return;
    }
    new Handler(localLooper).post(new az(this, paramObservable, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */