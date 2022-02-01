package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.AITranslator;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.ColorRingTipsBar;
import com.tencent.mobileqq.activity.aio.tips.CommingRingTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.activity.aio.tips.RedPacketShower;
import com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.VibrateListener;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnBottomOverScrollListener;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import cooperation.qlink.QQProxyForQlink;
import dhy;
import dhz;
import dia;
import dib;
import dic;
import did;
import die;
import dif;
import dig;
import dih;
import dii;
import dij;
import dik;
import dil;
import dim;
import din;
import dio;
import dip;
import diq;
import dir;
import dis;
import diu;
import div;
import diw;
import dix;
import diy;
import diz;
import dja;
import djb;
import djc;
import djd;
import djg;
import djh;
import dji;
import djk;
import djl;
import djm;
import djq;
import djr;
import djs;
import djt;
import dju;
import djv;
import djw;
import djx;
import djy;
import djz;
import dka;
import dkb;
import dkc;
import dkd;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.app.permission.PermissionManager;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseChatPie
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, MediaPlayerManager.Listener, CheckPttListener, VibrateListener, ChatXListView.OnBottomOverScrollListener, EmoticonCallback, AbsListView.OnScrollListener, OverScrollViewListener, XPanelContainer.PanelCallback, Observer
{
  public static final String b = "is_from_manage_stranger";
  private static final int ck = 1;
  private static final int cl = 2;
  protected static final int d = 200;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  private static boolean v = false;
  private String K;
  public float a;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dig(this);
  public final Handler a;
  protected MessageQueue.IdleHandler a;
  protected SpannableString a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  protected ViewGroup a;
  public EditText a;
  protected ImageView a;
  protected LinearLayout a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  protected RelativeLayout a;
  public TextView a;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  public AIOTipsController a;
  public ChatAdapter1 a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  protected PlusPanel a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private final StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
  protected ColorRingTipsBar a;
  protected CommingRingTipsBar a;
  public FraudTipsBar a;
  protected LightalkBlueTipsBar a;
  public QQOperateTips a;
  protected RedPacketShower a;
  protected TipsManager a;
  protected VideoStatusTipsBar a;
  protected VipFunCallTipsBar a;
  public BaseActivity a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new djh(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new djg(this);
  protected FriendListHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new djd(this);
  public QQAppInterface a;
  public QQMapActivityProxy a;
  public QQMessageFacade.RefreshMessageContext a;
  public ChatXListView a;
  protected ChatMessage a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private SogouEmoji jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji;
  protected EmoticonMainPanel a;
  private EmotionPreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout;
  private FastImagePreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  protected PortalManager a;
  public TroopAioTips a;
  protected QQRecorder a;
  protected IconPopupWindow a;
  public QQProgressDialog a;
  protected ScrollerRunnable a;
  public ToastStyleDialog a;
  public PatchedButton a;
  public XPanelContainer a;
  private dka jdField_a_of_type_Dka;
  protected CharSequence a;
  public Runnable a;
  public final String a;
  public Comparator a;
  protected List a;
  protected boolean a;
  public int b;
  protected long b;
  public Dialog b;
  protected SpannableString b;
  public View b;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout b;
  public TextView b;
  private ToastStyleDialog jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public Comparator b;
  private List jdField_b_of_type_JavaUtilList;
  protected boolean b;
  protected int c;
  protected long c;
  public Dialog c;
  protected SpannableString c;
  protected View c;
  protected ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  protected String c;
  public boolean c;
  private final int cf = 300;
  private int cg = 0;
  private int ch = 1;
  private int ci = 0;
  private int cj = 1;
  private int cm = 0;
  private int cn = 0;
  private int co = 0;
  private int cp = 0;
  private int cq;
  protected long d;
  public Dialog d;
  protected SpannableString d;
  private View d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  protected String d;
  public boolean d;
  protected int e;
  public Dialog e;
  private SpannableString jdField_e_of_type_AndroidTextSpannableString;
  private View jdField_e_of_type_AndroidViewView;
  protected ImageView e;
  protected TextView e;
  public boolean e;
  private long jdField_f_of_type_Long = -1L;
  public Dialog f;
  private View jdField_f_of_type_AndroidViewView = null;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  public TextView f;
  public boolean f;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  protected boolean h;
  protected int i;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  boolean jdField_i_of_type_Boolean = false;
  private TextView j;
  public volatile boolean j;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  boolean jdField_k_of_type_Boolean = true;
  protected boolean l = true;
  private boolean o;
  private boolean p;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean w = true;
  private boolean x = false;
  private boolean y = true;
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangString = "ChatActivity";
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 131074;
    this.jdField_e_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsColorRingTipsBar = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsCommingRingTipsBar = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = null;
    this.jdField_a_of_type_JavaLangRunnable = new diq(this);
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilComparator = new djr(this);
    this.jdField_b_of_type_JavaUtilComparator = new djs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.b(new djz(this, paramInt2, paramInt1, paramString));
  }
  
  private void a(long paramLong)
  {
    this.jdField_b_of_type_JavaLangRunnable = new dis(this, paramLong);
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m;
    if (paramBoolean3) {
      m = 2131366525;
    }
    for (;;)
    {
      QQToast.a(paramContext, m, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
      return;
      if (paramBoolean2) {
        m = 2131366526;
      } else if (paramBoolean1) {
        m = 2131366524;
      } else {
        m = 2131366523;
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Map)paramMessage.obj;
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.get("chatMessage"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + m);
    }
    if (m < 0) {}
    for (;;)
    {
      return;
      int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
      if ((m >= n - i1) && (m <= i2 - i3))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s());
        if ((localObject != null) && ((localObject instanceof LinearLayout)))
        {
          paramMessage = (RichStatus.SigZanInfo)paramMessage.get("sigZanInfo");
          if ((AIOUtils.a((View)localObject) instanceof RichStatItemBuilder.Holder))
          {
            localObject = (RichStatItemBuilder.Holder)AIOUtils.a((View)localObject);
            if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (paramMessage.jdField_a_of_type_JavaLangString.equals(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_JavaLangString)))
            {
              ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_Int = paramMessage.jdField_b_of_type_Int;
              ((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int = paramMessage.jdField_c_of_type_Int;
              ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMessage.jdField_b_of_type_Int));
              SignatureManager localSignatureManager = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
              if (paramMessage.jdField_c_of_type_Int == 0) {}
              for (paramMessage = localSignatureManager.a(((RichStatItemBuilder.Holder)localObject).jdField_b_of_type_Int, 7); paramMessage != null; paramMessage = localSignatureManager.a(((RichStatItemBuilder.Holder)localObject).jdField_b_of_type_Int, 8))
              {
                ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramMessage, null, null, null);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363684);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramAbsShareMsg = new dib(this, paramAbsShareMsg, localBaseActivity);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    a(2, paramString, paramLong);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong, true);
    if (paramLong == 0L) {
      StreamDataManager.a(paramString);
    }
  }
  
  @SuppressLint({"ResourceAsColor"})
  private void ad()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
      {
        Object localObject2 = new dji(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296376);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427593));
        localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493126));
        int m = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493127);
        localLayoutParams.rightMargin = m;
        localLayoutParams.leftMargin = m;
        localLayoutParams.addRule(10);
        this.jdField_j_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131369184));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))) {
            break label883;
          }
          this.jdField_j_of_type_AndroidWidgetTextView.setEnabled(false);
          this.jdField_j_of_type_AndroidWidgetTextView.setClickable(false);
          label291:
          this.jdField_j_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131492870));
          this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427593));
          this.jdField_j_of_type_AndroidWidgetTextView.setGravity(17);
          this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131428004));
          this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject2);
          Object localObject3 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_j_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
          localObject3 = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((View)localObject3).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427592));
          LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density, -1);
          m = (int)(16.0F * this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density);
          localLayoutParams1.setMargins(0, m, 0, m);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, localLayoutParams1);
          this.jdField_k_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366100));
          this.jdField_k_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131492870));
          this.jdField_k_of_type_AndroidWidgetTextView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427593));
          this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131428004));
          this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_k_of_type_AndroidWidgetTextView.getText());
          this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject2);
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(3));
          this.jdField_k_of_type_AndroidWidgetTextView.setGravity(17);
          localObject2 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_k_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131296376);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, 0, localLayoutParams);
        }
      }
      else
      {
        if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
          break label902;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131369184));
        this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297035);
        if (localObject1 != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          localLayoutParams.topMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493126));
          ((View)localObject1).setLayoutParams(localLayoutParams);
        }
        return;
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131366102));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
          break;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131366101));
        this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        break;
        label883:
        this.jdField_j_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_j_of_type_AndroidWidgetTextView.setClickable(true);
        break label291;
        label902:
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131366102));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
        }
        else
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131366101));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        }
      }
    }
  }
  
  private void ae()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297035);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void af()
  {
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.K = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_h_of_type_Boolean = true;
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (this.K == null) {}
    for (String str = "";; str = this.K)
    {
      localEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      this.jdField_h_of_type_Boolean = false;
      return;
    }
  }
  
  private void ag()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if ((!StringUtil.b(this.K)) || (!StringUtil.b(String.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText())))) {
        break label65;
      }
    }
    label65:
    while ((this.K != null) && (this.K.equals(String.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText())))) {
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetEditText.getText());
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    DraftSummaryInfo localDraftSummaryInfo = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (localDraftSummaryInfo != null)
    {
      localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, localDraftSummaryInfo.getSummary(), localDraftSummaryInfo.getTime());
      return;
    }
    localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, "", 0L);
  }
  
  private void ah() {}
  
  private void ai()
  {
    aq();
    if (this.jdField_c_of_type_Int == 0) {}
    label11:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
      return;
    }
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int i7 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
    int i5 = this.jdField_c_of_type_Int;
    Object localObject1;
    label128:
    int i2;
    int i6;
    int n;
    int i3;
    switch (this.jdField_c_of_type_Int & 0xFFFF0000)
    {
    default: 
      localObject1 = localList1;
      i2 = this.cg;
      i6 = localList1.size();
      n = ((List)localObject1).size();
      i3 = this.jdField_c_of_type_Int & 0xFFFF;
      if ((i3 == 0) && (this.jdField_d_of_type_AndroidViewView == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1))) {
        i3 = 2;
      }
      break;
    }
    for (;;)
    {
      int m;
      long l1;
      switch (i3)
      {
      case 4: 
      default: 
        m = i2;
        if (localList1 != localObject1)
        {
          if ((i6 <= 0) || (n <= 0)) {
            break label1838;
          }
          l1 = ((ChatMessage)localList1.get(i6 - 1)).uniseq;
          m = n - 1;
          if (m < 0) {
            break label1838;
          }
          if (((ChatMessage)((List)localObject1).get(m)).uniseq != l1) {
            break label1527;
          }
          label298:
          if (m < 0) {
            break label1534;
          }
          m = n - (i6 - this.cg + n - 1 - m);
        }
        break;
      }
      label318:
      boolean bool;
      for (;;)
      {
        if (i3 == 5)
        {
          m = this.cg;
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m(), -1, null);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363741), 3000).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          m = n - (i6 - m);
          label387:
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
          {
            i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            if (i1 != -1)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(i1, i1, this.jdField_b_of_type_JavaLangRunnable);
              this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
            }
          }
          if ((!this.q) || (n == 0)) {
            break label1639;
          }
          bool = true;
          label446:
          d(bool);
          this.jdField_c_of_type_Int = 0;
          this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
          this.cg = m;
          switch (i5 & 0xFFFF0000)
          {
          default: 
            label500:
            if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
            {
              localObject1 = (MessageForShakeWindow)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1);
              if (!((MessageForShakeWindow)localObject1).isSendFromLocal()) {
                break label1674;
              }
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new din(this, (MessageForShakeWindow)localObject1), 20L);
              this.jdField_b_of_type_JavaUtilList.clear();
            }
            label573:
            if (m != n) {
              break label11;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
            localObject1 = localList1;
            break label128;
            List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(localList2);
            }
            Object localObject2;
            if ((this.s) && (localList2.size() > 0))
            {
              ChatMessage localChatMessage = (ChatMessage)localList2.get(localList2.size() - 1);
              if (!localChatMessage.isSend()) {
                localChatMessage.mAnimFlag = true;
              }
              localChatMessage.mPendantAnimatable = true;
              if ((localChatMessage instanceof MessageForMarketFace))
              {
                localObject2 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localChatMessage.parse();
                  localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
                }
                if ((((MarkFaceMessage)localObject1).mobileparam != null) && (((MarkFaceMessage)localObject1).mobileparam.length > 0) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
                  ((MessageForMarketFace)localChatMessage).needToPlay = true;
                }
              }
            }
            if (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
            {
              localObject1 = ChatActivityUtils.b(localList2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              label830:
              if (this.jdField_a_of_type_Boolean)
              {
                if ((1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (localObject1 != null) || (localList2.size() != 0)) {
                  break label968;
                }
                localObject2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString);
                label885:
                if (localObject2 == null) {
                  break label986;
                }
                a(true);
                this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject2);
              }
            }
            for (;;)
            {
              localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(localList2, (CharSequence)localObject1);
              localObject1 = localList2;
              break;
              localObject1 = ChatActivityUtils.a(localList2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              break label830;
              label968:
              localObject2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              break label885;
              label986:
              a(false);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new dik(this));
            }
            for (;;)
            {
              m = n;
              break;
              this.co += 1;
              if (QLog.isColorLevel()) {
                QLog.d("ChatActivity", 2, "[refreshListAdapter]: refreshBottomCount=" + this.co + ",refreshDelayForNextPie=" + v);
              }
              if (v)
              {
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new dil(this));
                v = false;
              }
              else if (this.co == 1)
              {
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1, 0);
              }
              else
              {
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new dim(this));
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1);
            m = n;
            continue;
            m = i2;
            if (i6 > 0)
            {
              m = i2;
              if (i1 >= 0)
              {
                if (n <= 0) {
                  break label1857;
                }
                if (i1 < localList1.size()) {
                  break label1854;
                }
                i1 = localList1.size() - 1;
                label1222:
                l1 = ((ChatMessage)localList1.get(i1)).uniseq;
                m = 0;
                label1240:
                if (m >= n) {
                  break label1849;
                }
                if (((ChatMessage)((List)localObject1).get(m)).uniseq == l1)
                {
                  label1265:
                  if ((m >= 0) || (localList1.size() <= i1 + 1)) {
                    break label1843;
                  }
                  l1 = ((ChatMessage)localList1.get(i1 + 1)).uniseq;
                  i1 = 0;
                  label1302:
                  if (i1 >= n) {
                    break label1843;
                  }
                  if (((ChatMessage)((List)localObject1).get(i1)).uniseq != l1) {
                    break label1385;
                  }
                  m = i1;
                  i2 = 1;
                }
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        if (m >= 0)
        {
          int i4 = this.cg + m;
          i1 = i4;
          if (i2 != 0) {
            i1 = i4 - 1;
          }
          if ((i7 < 0) && (m == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.B();
            m = i1;
            break label318;
            m += 1;
            break label1240;
            label1385:
            i1 += 1;
            break label1302;
          }
          if (i7 < 0)
          {
            i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m()).getBottom();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.C();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(m + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m(), i2 - i4 + i7);
            m = i1;
            break label318;
          }
          i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
          i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m()).getBottom();
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(m + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m(), i2 - i4);
          m = i1;
          break label318;
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.C();
        m = n;
        break label318;
        label1527:
        m -= 1;
        break;
        label1534:
        m = n;
        break label318;
        if (i3 == 6)
        {
          i2 = this.cg;
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
          m = 0;
          label1562:
          if (m < i1)
          {
            localObject1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(m);
            if ((localObject1 == null) || (((ChatMessage)localObject1).msgtype != -4009)) {}
          }
          for (;;)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
            if (m == 0) {}
            for (i1 = 0;; i1 = -1)
            {
              ((ScrollerRunnable)localObject1).a(m, i1, null);
              m = n - (i6 - i2);
              break;
              m += 1;
              break label1562;
            }
            label1639:
            bool = false;
            break label446;
            if (!this.jdField_j_of_type_Boolean) {
              break label500;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1001, new Object[0]);
            this.jdField_j_of_type_Boolean = false;
            break label500;
            label1674:
            l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + ((MessageForShakeWindow)localObject1).shmsgseq + ",msgUid is:" + ((MessageForShakeWindow)localObject1).msgUid + ",uniseq is:" + ((MessageForShakeWindow)localObject1).uniseq + ",onlineStatus is:" + l1 + ",userActiveStatus is:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.aO);
            }
            if ((l1 != 11L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.aO != 0)) {
              break label573;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dio(this, (MessageForShakeWindow)localObject1), 20L);
            break label573;
            m = 0;
          }
        }
        break label387;
        label1838:
        m = -1;
        break label298;
        label1843:
        i2 = 0;
        continue;
        label1849:
        m = -1;
        break label1265;
        label1854:
        break label1222;
        label1857:
        m = -1;
        i2 = 0;
      }
    }
  }
  
  private void aj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void ak()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout = ((EmotionPreviewLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903072, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131297027);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    }
  }
  
  private void al()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onShow_videoStatus: mEnterExtPanel = " + this.ci + ", mExtPanelOnResumeTimes = " + this.cj);
    }
    if (this.ci != 0)
    {
      int m = this.cj - 1;
      this.cj = m;
      if (m == 0)
      {
        if (this.ci != 1) {
          break label101;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new dja(this));
      }
    }
    for (;;)
    {
      this.ci = 0;
      return;
      label101:
      if (this.ci == 4) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new djb(this));
      }
    }
  }
  
  private void am()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
    if (this.u)
    {
      k(true);
      this.u = false;
    }
    this.jdField_e_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366308), "qqsetting_enter_sendmsg_key", false);
    String str;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(4);
      if (this.jdField_a_of_type_Dka == null) {
        this.jdField_a_of_type_Dka = new dka(this, null);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_Dka);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_Dka);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("refuse_show_share_result_dialog", false);
      if ((this.jdField_f_of_type_Boolean) && (!bool) && (this.jdField_k_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
        str = ((Bundle)localObject).getString("app_name");
        localObject = StructMsgFactory.a((Bundle)localObject);
        if ((localObject == null) || (!(localObject instanceof AbsShareMsg))) {
          break label233;
        }
      }
    }
    label233:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      a((AbsShareMsg)localObject, str);
      this.jdField_k_of_type_Boolean = false;
      as();
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(null);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(null);
      break;
    }
  }
  
  private void an()
  {
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void ao()
  {
    AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
  
  private void ap()
  {
    if (QQLSRecentManager.jdField_e_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    ThreadManager.b().postDelayed(new djc(this), 1000L);
  }
  
  private void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "cancelDelAnim() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(16);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.D();
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null)) {
      ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_b_of_type_AndroidViewViewGroup);
    }
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
  }
  
  private void ar()
  {
    if ((ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)) {
      if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString))) {
        break label328;
      }
    }
    label304:
    label328:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.jdField_h_of_type_AndroidViewView + ", sessionInfo.chatBg.path=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_h_of_type_AndroidViewView != null) && (QLog.isColorLevel()))
      {
        if (this.jdField_h_of_type_AndroidViewView.getVisibility() == 0) {
          QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label304;
        }
        if ((this.jdField_h_of_type_AndroidViewView == null) || (this.jdField_h_of_type_AndroidViewView.getVisibility() != 0)) {
          break label212;
        }
      }
      label212:
      while (this.jdField_h_of_type_AndroidViewView == null)
      {
        return;
        if (this.jdField_h_of_type_AndroidViewView.getVisibility() == 4)
        {
          QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
          break;
        }
        QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = GONE");
        break;
        if (this.jdField_h_of_type_AndroidViewView == null)
        {
          this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          this.jdField_h_of_type_AndroidViewView.setBackgroundColor(1996488704);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.addRule(6, 2131297034);
          localLayoutParams.addRule(2, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
          this.jdField_h_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidViewView);
          return;
        }
        this.jdField_h_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_h_of_type_AndroidViewView);
      this.jdField_h_of_type_AndroidViewView = null;
      return;
    }
  }
  
  private void as()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 4);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        f(str);
      }
    }
  }
  
  private void at()
  {
    boolean bool = true;
    long l1 = System.currentTimeMillis();
    Object localObject;
    int n;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.p))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
          break label264;
        }
        if (QLog.isColorLevel()) {
          QLog.d("save_inptut", 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label265;
      }
      n = 2;
      if (((ExtensionInfo)localObject).chatInputType == n) {
        break label281;
      }
      ((ExtensionInfo)localObject).chatInputType = n;
    }
    label149:
    label281:
    for (int m = 1;; m = 0)
    {
      int i1;
      if ((this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() == 0))
      {
        i1 = 1;
        if (((ExtensionInfo)localObject).showC2CPanel != i1)
        {
          ((ExtensionInfo)localObject).showC2CPanel = i1;
          m = 1;
        }
        if (m != 0) {
          ThreadManager.a().post(new dkd((ExtensionInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        }
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
        if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (n != 1) {
            break label275;
          }
        }
      }
      for (;;)
      {
        AIOInputTypeHelper.a((QQAppInterface)localObject, bool);
        if (QLog.isColorLevel()) {
          QLog.d("save_inptut", 2, "saveC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
        }
        return;
        n = 1;
        break;
        i1 = 0;
        break label149;
        bool = false;
      }
    }
  }
  
  private void au()
  {
    PendingIntent localPendingIntent = (PendingIntent)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
    if ((localPendingIntent != null) && ((localPendingIntent instanceof PendingIntent))) {}
    try
    {
      localPendingIntent.send();
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("ChatActivity", 4, localCanceledException.getMessage());
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!AIOUtils.b())) {
      if (this.jdField_c_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903085, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296739);
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296741));
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label150;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b())) {
          ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131297027);
        }
      }
    }
    label149:
    label150:
    while (this.jdField_c_of_type_AndroidViewView == null)
    {
      break label149;
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean2) {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(2131366076);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidViewView.setSelected(paramBoolean2);
        return;
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          break;
        }
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131297027);
        break;
        this.jdField_h_of_type_AndroidWidgetTextView.setText(2131366077);
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, "");
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    int m;
    int n;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      m = 1;
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        break label219;
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramInt1 != 1) {
        break label213;
      }
      n = 1;
      label45:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, n + "", m + "", paramInt2 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt1 + ", sessionType = " + m + ", seconds = " + paramInt2);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        m = 2;
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        m = 3;
        break;
      }
      m = 4;
      break;
      label213:
      n = 2;
      break label45;
      label219:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", m + "", paramInt2 + "", "");
    }
  }
  
  private SpannableString e()
  {
    if (this.jdField_e_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130837664);
      SpannableString localSpannableString = new SpannableString("语音输入");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_e_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_e_of_type_AndroidTextSpannableString;
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(34);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
  }
  
  private void g(boolean paramBoolean)
  {
    int n = 1;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      m = 1;
      n = 0;
    }
    for (;;)
    {
      if ((m == 0) && (n == 0))
      {
        return;
        if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          m = 0;
        }
      }
      else
      {
        Object localObject;
        ChatMessage localChatMessage;
        long l1;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
          int i1 = ((List)localObject).size();
          n = 0;
          if (n >= i1) {
            break label290;
          }
          localChatMessage = (ChatMessage)((List)localObject).get(n);
          if (!localChatMessage.isread) {
            if (m != 0) {
              l1 = localChatMessage.shmsgseq;
            }
          }
        }
        for (;;)
        {
          label137:
          if (QLog.isColorLevel()) {
            QLog.d(AioAnimationDetector.jdField_a_of_type_JavaLangString, 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + paramBoolean + ", lastMsgTimeOrSeq=" + l1);
          }
          localObject = AioAnimationDetector.a();
          ((AioAnimationDetector)localObject).jdField_a_of_type_Boolean = paramBoolean;
          ((AioAnimationDetector)localObject).jdField_a_of_type_Long = l1;
          if (paramBoolean) {}
          for (;;)
          {
            ChatActivityFacade.jdField_a_of_type_Long = l1;
            return;
            l1 = localChatMessage.time;
            break label137;
            n += 1;
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (localObject == null) {
              break label290;
            }
            if (m != 0)
            {
              l1 = ((QQMessageFacade.Message)localObject).shmsgseq;
              break label137;
            }
            l1 = ((QQMessageFacade.Message)localObject).time;
            break label137;
            l1 += 1L;
          }
          label290:
          l1 = -1L;
        }
      }
      n = 0;
      m = 0;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    g(paramBoolean);
  }
  
  private void i(boolean paramBoolean)
  {
    j(true);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4, paramBoolean);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837543);
  }
  
  private void j(boolean paramBoolean)
  {
    int n = 8;
    this.jdField_f_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_f_of_type_AndroidWidgetImageView;
    int m;
    if (paramBoolean)
    {
      m = 0;
      ((ImageView)localObject).setVisibility(m);
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      m = n;
      if (!paramBoolean) {
        m = 0;
      }
      ((EditText)localObject).setVisibility(m);
      if (!paramBoolean) {
        break label102;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130837585);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842210);
      this.jdField_d_of_type_AndroidWidgetImageView.setPadding(AIOUtils.a(32.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()), 0, 0, 0);
    }
    label102:
    while (((this instanceof TroopChatPie)) && (((TroopChatPie)this).k()))
    {
      return;
      m = 8;
      break;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130837664);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130841709);
    this.jdField_d_of_type_AndroidWidgetImageView.setPadding(AIOUtils.a(32.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()), 0, 0, 0);
  }
  
  private void k(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 10004);
    this.ci = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.cj = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("isBack2Root");
    this.jdField_f_of_type_Boolean = paramIntent.getExtras().containsKey("res_share_id");
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("is_share_flag");
    }
    this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.p) {
      break label7;
    }
    label7:
    label192:
    label213:
    for (;;)
    {
      return;
      if (!BaseChatItemLayout.jdField_b_of_type_Boolean)
      {
        Object localObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (!((FriendsManagerImp)localObject).d())
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
            l(paramBoolean);
          }
          ThreadManager.b(new djt(this));
          return;
        }
        long l1 = System.currentTimeMillis();
        ExtensionInfo localExtensionInfo = ((FriendsManagerImp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        localObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
          }
        }
        else
        {
          if (((ExtensionInfo)localObject).chatInputType != 2) {
            break;
          }
          if (((ExtensionInfo)localObject).showC2CPanel != 1) {
            break label192;
          }
          l(paramBoolean);
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label213;
          }
          QLog.d("save_inptut", 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l1));
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("save_inptut", 2, "showAudioPanelIfNeed | ExtensionInfo = null");
          return;
          if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837544);
          }
        }
      }
    }
  }
  
  private void l(Intent paramIntent)
  {
    int n = 8;
    j(0);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int m = n;
    switch (i1)
    {
    default: 
      m = n;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(m);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      String str = paramIntent.getStringExtra("input_text");
      paramIntent.removeExtra("input_text");
      if (str == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      return;
      m = 6;
      continue;
      m = 6;
    }
    af();
  }
  
  private void l(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_input.name()))
      {
        i(false);
        this.u = false;
      }
    }
    while (!this.u)
    {
      return;
      this.u = true;
      return;
    }
    i(true);
    this.u = false;
  }
  
  private void m(Intent paramIntent)
  {
    if (paramIntent.getExtras().containsKey("forward_type"))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363814, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
    }
    else {
      return;
    }
    int m = paramIntent.getIntExtra("forward_type", 2147483647);
    if (m == 0) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new djv(this, paramIntent, paramIntent), 500L);
      a(false, null);
      return;
      if ((m == 1001) || (m == -4)) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      if (((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).isActive(this.jdField_a_of_type_AndroidWidgetEditText)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    do
    {
      do
      {
        View localView;
        do
        {
          return;
          localView = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        } while ((localView == null) || (localView.getVisibility() != 0));
        if (localView != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel) {
          break;
        }
      } while (!paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    } while (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837544);
  }
  
  private void n(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_i_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_b_of_type_Boolean)) {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((TextView)localObject1).setId(2131296332);
      ((TextView)localObject1).setBackgroundResource(2130837662);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(3.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131297034);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(25.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297035);
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront((View)localObject1);
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131296332);
      }
    }
    Object localObject2 = this.jdField_i_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void n(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    if (paramIntent.getLongExtra("res_share_id", 0L) > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new djw(this, paramIntent), 20L);
    }
  }
  
  private void o(int paramInt)
  {
    int m;
    if (paramInt == 1) {
      m = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, m + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 2) {
        m = 2;
      } else {
        m = 3;
      }
    }
  }
  
  private void o(Intent paramIntent)
  {
    if (BaseChatItemLayout.jdField_b_of_type_Boolean) {
      a(false, null);
    }
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
    }
    for (;;)
    {
      this.ci = paramIntent.getIntExtra("enter_ext_panel", 0);
      this.cj = paramIntent.getIntExtra("ext_panel_onresume", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "mEnterExtPanel = " + this.ci + ", mExtPanelOnResumeTimes = " + this.cj);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
      }
      AioAnimationDetector.a().a();
      return;
      if (localBundle != null)
      {
        this.jdField_c_of_type_Boolean = localBundle.getBoolean("isBack2Root");
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
        }
      }
    }
  }
  
  private void p(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("msg_uni_seq", -1L);
    if (l1 >= 0L)
    {
      paramIntent.removeExtra("msg_uni_seq");
      boolean bool = paramIntent.getBooleanExtra("click_msg", false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dir(this, l1, bool), 300L);
    }
  }
  
  private void q(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.jdField_i_of_type_Boolean))
    {
      int m = paramIntent.getInt("aio_msg_source", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + m);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), String.valueOf(m), "", "");
    }
  }
  
  private void r(Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        j(0);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
      }
    }
    FriendsManagerImp localFriendsManagerImp;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.p)) {
        break;
      }
      localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramIntent = localFriendsManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      if (paramIntent != null) {
        break label395;
      }
    } while (!localFriendsManagerImp.d());
    if (QLog.isColorLevel()) {
      QLog.d("save_inptut", 2, "chooseC2CChatInputType get ExtensionInfo = null");
    }
    paramIntent = new ExtensionInfo();
    paramIntent.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramIntent.timestamp = System.currentTimeMillis();
    if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      paramIntent.chatInputType = 0;
      label171:
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = paramIntent;
    }
    label395:
    for (;;)
    {
      switch (paramIntent.chatInputType)
      {
      }
      for (;;)
      {
        k(false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("save_inptut", 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
        return;
        paramIntent.chatInputType = 1;
        break label171;
        AIOInputTypeHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (AIOInputTypeHelper.jdField_a_of_type_Boolean)
        {
          paramIntent.chatInputType = 2;
          j(true);
        }
        else if (AIOInputTypeHelper.jdField_b_of_type_Boolean)
        {
          paramIntent.chatInputType = 1;
          j(false);
        }
        else
        {
          paramIntent.chatInputType = 2;
          j(true);
          continue;
          j(true);
          t();
          continue;
          j(false);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.p))
          {
            if (QLog.isColorLevel()) {
              QLog.d("save_inptut", 2, "chooseC2CChatInputType isSimpleBar = " + this.p);
            }
            j(false);
          }
        }
      }
    }
  }
  
  protected void A()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      f(true);
    }
    TextTranslationItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (this.r) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711689);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, " read confirm onPause  mReadConfirmHandler");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.c();
      }
      this.jdField_i_of_type_Boolean = false;
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).c();
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime doOnPause end");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ChatActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  public void B()
  {
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    if (ChatBackground.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    ar();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a();
    }
    StartupTracker.a("AIO_doOnResume_updateUI", null);
  }
  
  public void C()
  {
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.f;
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler == null) {
      this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new dic(this);
    }
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    B();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(131072);
    ah();
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume end");
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
  }
  
  protected void D() {}
  
  public void E()
  {
    AudioUtil.b(2131165187, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public void F()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_b_of_type_Int = 0;
    this.q = true;
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a().getCount() - 1);
    }
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if ((!this.jdField_c_of_type_Boolean) || (f())) {
      v();
    }
  }
  
  void I()
  {
    SVIPHandler localSVIPHandler = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    if (localSVIPHandler.a()) {
      localSVIPHandler.b();
    }
  }
  
  public void J()
  {
    i();
    ar();
  }
  
  public void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void L()
  {
    b(true, this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
  }
  
  public void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(3);
    b(false, false);
    r();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 500L);
  }
  
  public void N()
  {
    int m = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int n = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((n & 0x4) != 0) {
      m = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, m - 200);
      return;
      if ((n & 0x2) != 0) {
        m = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void O()
  {
    if (this.w)
    {
      g();
      this.w = false;
    }
  }
  
  public void P()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PeakService.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startService(localIntent);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(32, 800L);
    an();
    AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
  }
  
  public void Q()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime onShow start");
    }
    StartupTracker.a("AIO_SysMsgCost", "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    ak();
    StartupTracker.a("AIO_onShow_emotion", null);
    O();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    am();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    al();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    q(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    P();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    ap();
    StartupTracker.a("AIO_onShow_setReaded", null);
    ThreadPriorityManager.a(false);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime onShow end");
    }
  }
  
  @TargetApi(11)
  protected void R()
  {
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840065);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      if (VersionUtils.e()) {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_e_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
        if (VersionUtils.e()) {
          this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.6F);
        }
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837585);
          this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366093));
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841082);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366092));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837585);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366093));
        t();
      }
      while (VersionUtils.e())
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841082);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366092));
        t();
      }
    }
  }
  
  public void S()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
      }
    }
  }
  
  public void T()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  public void U()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  public void V()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void W()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    X();
    djm localdjm = new djm(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(localdjm, 60L);
        return;
      }
      localdjm.run();
      return;
    }
  }
  
  public void X()
  {
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidViewView.getParent() != null)) {
      ((ViewGroup)this.jdField_f_of_type_AndroidViewView.getParent()).removeView(this.jdField_f_of_type_AndroidViewView);
    }
    this.jdField_f_of_type_AndroidViewView = null;
  }
  
  public void Y() {}
  
  public void Z()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  protected Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558902);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2130903216);
      localTextView1 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131297367);
      localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131296606);
      TextView localTextView2 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131297370);
      TextView localTextView3 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131297371);
      localTextView1.setText(2131367630);
      ((TextView)localObject).setText(2131367633);
      localTextView3.setText(2131367632);
      localTextView3.setOnClickListener(new did(this));
      localTextView2.setText(2131365736);
      localTextView2.setOnClickListener(new die(this));
      return this.jdField_c_of_type_AndroidAppDialog;
    case 231: 
      this.jdField_d_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558902);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2130903050);
      ((TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131296606)).setText(2131367626);
      return this.jdField_d_of_type_AndroidAppDialog;
    case 232: 
      this.jdField_e_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558902);
      this.jdField_e_of_type_AndroidAppDialog.setContentView(2130904474);
      localTextView1 = (TextView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131299481);
      localObject = (ImageView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131296598);
      localTextView1.setText(2131366159);
      ((ImageView)localObject).setImageResource(2130838252);
      return this.jdField_e_of_type_AndroidAppDialog;
    }
    this.jdField_f_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558902);
    this.jdField_f_of_type_AndroidAppDialog.setContentView(2130904474);
    TextView localTextView1 = (TextView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131299481);
    Object localObject = (ImageView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131296598);
    localTextView1.setText(2131366158);
    ((ImageView)localObject).setImageResource(2130838242);
    return this.jdField_f_of_type_AndroidAppDialog;
  }
  
  public SpannableString a()
  {
    if (this.jdField_d_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130837613);
      SpannableString localSpannableString = new SpannableString("发送");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_d_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_d_of_type_AndroidTextSpannableString;
  }
  
  public View a(int paramInt)
  {
    PlusPanel localPlusPanel = null;
    if (paramInt == 3)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903081, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
      }
      localPlusPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
    }
    do
    {
      return localPlusPanel;
      if (paramInt == 2)
      {
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903288, null));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight(), this.jdField_d_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l1));
        }
        return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      }
    } while (paramInt != 4);
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903828, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (InputLinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public StructingMsgItemBuilder.ViewCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public MagicfaceViewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = new MagicfaceViewController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  }
  
  @Deprecated
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void a(int paramInt)
  {
    int m = paramInt & 0xFFFF0000;
    if ((paramInt & 0xFFFF) > (this.jdField_c_of_type_Int & 0xFFFF)) {
      paramInt &= 0xFFFF;
    }
    long l1;
    for (;;)
    {
      this.jdField_c_of_type_Int = (paramInt | m);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
      {
        if (m < 196608) {
          break label125;
        }
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(12))
        {
          l1 = SystemClock.uptimeMillis();
          if (l1 - this.jdField_f_of_type_Long <= 1000L) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
        }
      }
      return;
      paramInt = this.jdField_c_of_type_Int & 0xFFFF;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 1000L - (l1 - this.jdField_f_of_type_Long));
    return;
    label125:
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new dii(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    h();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getExtras() != null) {
        bool1 = paramIntent.getExtras().getBoolean("progress2View");
      }
    }
    if (paramInt1 == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setCanLock(false);
    }
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          localObject1 = paramIntent.getExtras();
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ForwardHandlerActivity.class);
          ((Intent)localObject2).putExtras(new Bundle((Bundle)localObject1));
          ((Intent)localObject2).addFlags(268435456);
          ((Intent)localObject2).addFlags(67108864);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(4, paramIntent);
      }
      return;
      if (paramInt1 == 4001) {
        EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramIntent);
      } else if ((paramInt1 == 103) && (!bool1)) {
        c(false);
      } else if ((paramInt1 == 101) && (paramInt2 != -1)) {
        c(false);
      } else if (paramInt2 == -1) {
        switch (paramInt1)
        {
        default: 
          break;
        case 0: 
          c(false);
          break;
        case 102: 
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FMActivity.class);
          ((Intent)localObject1).putExtra("selectMode", false);
          ((Intent)localObject1).putExtra("localSdCardfile", 1408041716);
          ((Intent)localObject1).putExtra("tab_tab_type", 0);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject1, 103);
          break;
        case 18: 
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
          }
          if (paramIntent != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
            }
            Object localObject3 = paramIntent.getExtras();
            if (localObject3 != null)
            {
              localObject1 = ((Bundle)localObject3).getString("latitude");
              localObject2 = ((Bundle)localObject3).getString("longitude");
              String str1 = ((Bundle)localObject3).getString("description");
              String str2 = ((Bundle)localObject3).getString("title");
              String str3 = ((Bundle)localObject3).getString("summary");
              localObject3 = ((Bundle)localObject3).getString("dianping_id");
              ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, str1, str2, str3, (String)localObject3);
            }
          }
          break;
        case 23: 
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SendPhotoActivity.class);
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(paramIntent.getData().getPath());
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName()).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq").putExtra("extra_image_sender_tag", "ChatActivity.ChatActivityConstants.UPLOAD_WATERMARK_SHOTPHOTO_REQUEST").putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          break;
        case 1: 
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramIntent, "UPLOAD_SHOTPHOTO_REQUEST");
          break;
        case 10: 
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, "ChatActivityConstants.ADD_CUSTOMEMOTION_REQUEST");
          break;
        case 3: 
          j(paramIntent);
          break;
        case 20: 
          c(true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(1024);
          break;
        case 21: 
          paramIntent.putExtra("is_forward_MESSAGE", true);
          paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366025));
          a(paramIntent.getExtras());
          break;
        case 2000: 
          bool2 = false;
          bool1 = bool2;
          if (paramIntent != null)
          {
            bool1 = bool2;
            if (paramIntent.getExtras() != null) {
              bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
            }
          }
          if (bool1) {
            v();
          } else {
            c(false);
          }
          break;
        }
      }
    }
    label876:
    int m;
    switch (paramInt2)
    {
    default: 
      if ((paramIntent != null) && ("AioVIP".equals(paramIntent.getStringExtra("callbackSn"))))
      {
        localObject1 = paramIntent.getStringExtra("result");
        m = -1;
      }
      break;
    }
    for (int i1 = -1;; i1 = paramInt1)
    {
      for (;;)
      {
        int n;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          paramInt1 = i1;
        }
        catch (JSONException localJSONException1)
        {
          int i2;
          localObject1 = null;
          paramInt1 = i1;
        }
        try
        {
          n = Integer.parseInt(((JSONObject)localObject1).getString("resultCode"));
          paramInt1 = i1;
          m = n;
          i1 = Integer.parseInt(((JSONObject)localObject1).getString("payState"));
          paramInt1 = i1;
          m = n;
          i2 = Integer.parseInt(((JSONObject)localObject1).getString("provideState"));
          paramInt1 = i2;
          m = n;
          n = paramInt1;
          if ((localObject1 == null) || (m != 0) || (i1 != 0) || (n != 0)) {
            break;
          }
          MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
          paramInt1 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "renewal_tail_tip_exit");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_paysucc", 0, 0, "" + paramInt1, "", "", "");
        }
        catch (JSONException localJSONException2)
        {
          label1126:
          break label1126;
        }
      }
      G();
      break label876;
      break;
      localJSONException1.printStackTrace();
      n = -1;
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dif(this), 1000L);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  protected void a(int paramInt, String paramString, long paramLong)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((paramString == null) || (paramLong == 0L));
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "disPlayAudioRecord updatePttRecordMessage: " + paramString);
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, -3, paramLong);
      c(true);
      return;
    }
    if (paramString != null)
    {
      paramString = StreamDataManager.a(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711688)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    c(true);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    long l2 = 0L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = l2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
      } while (MsgProxyUtils.n(((ChatMessage)localObject2).msgtype));
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((ChatMessage)localObject2).uniseq);
    }
    localObject1 = new diu(this);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramBoolean)
    {
      a(paramLong);
      Log.i("app2", "scrollToMsgForC2C-->uniseq=" + paramLong + " fistseq=" + l1 + " mr.shmsgseq=" + ((MessageRecord)localObject2).shmsgseq + " shmsgseq=" + l2 + " click=" + paramBoolean);
      if ((localObject2 != null) && (l1 - l2 <= 200L))
      {
        if ((int)l1 <= l2 + 1L) {
          break label301;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
      }
    }
    label301:
    int m;
    do
    {
      return;
      this.jdField_b_of_type_JavaLangRunnable = null;
      break;
      m = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)localObject2);
    } while (m == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(m, m, this.jdField_b_of_type_JavaLangRunnable);
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    c(true);
    b(paramIntent);
    a(false);
    j();
    h();
    this.p = b();
    i();
    k();
    l(paramIntent);
    r(paramIntent);
    e(paramIntent);
    o();
    l();
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297354);
      paramIntent.setPadding(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492917), paramIntent.getPaddingTop(), paramIntent.getPaddingRight(), paramIntent.getPaddingBottom());
    }
    this.ch = 1;
    this.q = true;
    d(false);
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int m = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "handleRequest requestCode " + m);
    }
    if ((m == 2) || (m == 1)) {
      j(paramIntent);
    }
    if (paramInt == 1) {
      FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    while ((paramInt != 2) || (this.l)) {
      return;
    }
    FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    S();
    if ((this.jdField_f_of_type_AndroidWidgetImageView != null) && (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837544);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageObserver paramMessageObserver, Intent paramIntent)
  {
    try
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (QLog.isDevelopLevel()) {
        QLog.d("Fight", 4, "fight.test.AbsStructMsg.STRUCT_TYPE_MULTI_MSG = 35");
      }
      while (localAbsStructMsg != null)
      {
        if ((localAbsStructMsg instanceof StructMsgForImageShare))
        {
          String str = paramIntent.getStringExtra("share_comment_message");
          paramMessageObserver = str;
          if (android.text.TextUtils.isEmpty(str)) {
            paramMessageObserver = localAbsStructMsg.mCommentText;
          }
          if (!android.text.TextUtils.isEmpty(paramMessageObserver))
          {
            AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
            ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageObserver);
          }
          paramIntent.removeExtra("forward_type");
          paramIntent.removeExtra("res_share_id");
          return;
        }
        if (35 == localAbsStructMsg.mMsgServiceID)
        {
          paramMessageObserver = MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.iterator();
          do
          {
            if (!paramMessageObserver.hasNext()) {
              break;
            }
          } while (((ChatMessage)paramMessageObserver.next()).isSend());
        }
        for (paramMessageObserver = Boolean.valueOf(false);; paramMessageObserver = Boolean.valueOf(true))
        {
          if (paramMessageObserver.booleanValue())
          {
            MultiMsgManager.a().a(paramQQAppInterface, paramContext, paramSessionInfo, null, paramIntent, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList);
            break;
          }
          MultiMsgManager.a().b();
          MultiMsgManager.a().c();
          paramMessageObserver = ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg);
          MultiMsgManager.a().b("StructMsg save db ");
          MultiMsgManager.a().c();
          MultiMsgManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().b, paramMessageObserver, null);
          break;
          ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
          break;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessage))) {
      return;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    paramMessage = new dip(this, paramMessage, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      aq();
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage, false);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + m);
    }
    if (m < 0) {
      return;
    }
    int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
    int i1 = m - n;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i1 + ",firstPos is:" + n + ",pos is:" + m);
      }
      a(196612);
      return;
    }
    boolean bool1 = this.jdField_b_of_type_AndroidViewView.isDrawingCacheEnabled();
    boolean bool2 = this.jdField_b_of_type_AndroidViewView.willNotCacheDrawing();
    this.jdField_b_of_type_AndroidViewView.setDrawingCacheEnabled(true);
    this.jdField_b_of_type_AndroidViewView.setWillNotCacheDrawing(false);
    Bitmap localBitmap = this.jdField_b_of_type_AndroidViewView.getDrawingCache();
    this.jdField_b_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (localBitmap != null) {}
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(localBitmap);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 2, "viewShotCopy is:" + localBitmap);
        }
        if (localBitmap != null)
        {
          localObject2 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297026);
          n = ((ViewGroup)localObject2).getChildCount();
          m = 0;
          if (m >= n) {
            break label932;
          }
          if (((ViewGroup)localObject2).getChildAt(m) == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)
          {
            if (m != -1) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "listViewIndex is:" + m + ",can not find listView");
            }
            a(196612);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = null;
        continue;
        m += 1;
        continue;
        Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131297034);
        ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131297034);
        ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131297034);
        ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131297034);
        ((ViewGroup)localObject2).addView(this.jdField_b_of_type_AndroidViewViewGroup, m + 1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(new djk(this));
        localObject3 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
        FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        Object localObject2 = new FrameLayout.LayoutParams(this.jdField_b_of_type_AndroidViewView.getWidth(), this.jdField_b_of_type_AndroidViewView.getHeight());
        ((FrameLayout.LayoutParams)localObject2).gravity = 51;
        this.jdField_b_of_type_AndroidViewViewGroup.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localFrameLayout.addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout.LayoutParams)localObject2).leftMargin = this.jdField_b_of_type_AndroidViewView.getLeft();
        ((FrameLayout.LayoutParams)localObject2).topMargin = this.jdField_b_of_type_AndroidViewView.getTop();
        ((FrameLayout.LayoutParams)localObject2).rightMargin = 0;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = 0;
        LinearInterpolator localLinearInterpolator = new LinearInterpolator();
        AnimationSet localAnimationSet = new AnimationSet(true);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject2).setDuration(400L);
        ((AlphaAnimation)localObject2).setInterpolator(localLinearInterpolator);
        localAnimationSet.addAnimation((Animation)localObject2);
        if (paramChatMessage.isSend())
        {
          localObject2 = new TranslateAnimation(0.0F, this.jdField_b_of_type_AndroidViewView.getRight(), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(400L);
          ((TranslateAnimation)localObject2).setInterpolator(localLinearInterpolator);
          localAnimationSet.addAnimation((Animation)localObject2);
          ((ImageView)localObject3).startAnimation(localAnimationSet);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new djl(this, localFrameLayout), 400L);
          this.jdField_b_of_type_AndroidViewView.setDrawingCacheEnabled(bool1);
          this.jdField_b_of_type_AndroidViewView.setWillNotCacheDrawing(bool2);
          if (localObject1 != null)
          {
            localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(15);
            ((Message)localObject1).obj = paramChatMessage;
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 200L);
          }
        }
        else
        {
          localObject2 = new TranslateAnimation(0.0F, -this.jdField_b_of_type_AndroidViewView.getRight(), 0.0F, 0.0F);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16, 300L);
        return;
      }
      label932:
      m = -1;
      continue;
      Object localObject1 = null;
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() != 1)) {}
    ActionGlobalData localActionGlobalData;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) && (paramInt == 1) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0));
      localActionGlobalData = MagicfaceActionManager.a(paramEmoticon, 1);
    } while ((!paramBoolean) && (localActionGlobalData != null) && (paramInt == 1) && (!localActionGlobalData.jdField_c_of_type_Boolean));
    a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramMessageForShakeWindow);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A2", "0X80065A2", 0, 0, "", "", "", "");
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    if ((paramEmoticonInfo2.jdField_c_of_type_Int == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramPicEmoticonInfo.a);
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711688))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
        a(0, null, -1L);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
    }
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "startRecord() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    String str = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, 2, null);
    if (QLog.isColorLevel()) {
      QLog.i("QQRecorder", 2, "path: " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
    AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(str);
  }
  
  public void a(IconPopupWindow paramIconPopupWindow)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = paramIconPopupWindow;
  }
  
  public void a(AbsListView.RecyclerListener paramRecyclerListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(paramRecyclerListener);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.cn = paramInt;
    if (paramInt == 0)
    {
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      ApngImage.resumeAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).b();
      if ((this.t) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.t = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711697);
        paramAbsListView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711697);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramAbsListView, BubbleManager.jdField_a_of_type_Long);
      }
      return;
    }
    URLDrawable.pause();
    if (!PicItemBuilder.jdField_g_of_type_Boolean)
    {
      AbstractGifImage.pauseAll();
      ApngImage.pauseAll();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
    if (paramInt == 1) {
      e(false);
    }
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.n();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m();
    int i1 = paramInt3 - i3 - i2;
    if (this.cg < i1)
    {
      int n = paramInt1 + paramInt2 - i2;
      int m = n;
      if (n >= paramInt3 - i3 - i2) {
        m = i1 - 1;
      }
      if (m >= this.cg) {
        this.cg = (m + 1);
      }
    }
    for (paramInt3 = i1 - this.cg;; paramInt3 = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 13, paramInt3, i1 - paramInt1 - paramInt2).sendToTarget();
      return;
    }
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localDraftTextInfo.type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localDraftTextInfo.text = paramCharSequence.toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDraftTextInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_c_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new diw(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, this.jdField_c_of_type_Long);
    o(paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    g(2131165188);
    a(paramString, this.jdField_c_of_type_Long, paramInt1, paramInt2);
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    int n = StreamDataManager.a(paramString);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    int m;
    if (paramLong == 0L)
    {
      m = 1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      if (m == 0) {
        break label220;
      }
      MessageRecord localMessageRecord = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2);
      ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
      paramLong = localMessageRecord.uniseq;
    }
    label220:
    for (;;)
    {
      if ((m != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)) {
        StreamDataManager.a(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong + ",time is:" + n);
      }
      if (n >= 512)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, paramLong, false);
        d(paramInt1, paramInt2);
      }
      a(0, paramString, paramLong);
      return;
      m = 0;
      break;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new djy(this, paramString2));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    StreamDataManager.a(paramString, 0, (int)(System.currentTimeMillis() / 1000L));
    StreamDataManager.a(paramString, "#!AMR\n".getBytes(), "#!AMR\n".getBytes().length, (short)0);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label92;
      }
      this.jdField_c_of_type_Long = 0L;
      g(2131165197);
    }
    for (;;)
    {
      c(true);
      return;
      label92:
      paramString = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        paramString.setPttStreamFlag(10001);
      }
      this.jdField_c_of_type_Long = paramString.uniseq;
      g(2131165189);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    StreamDataManager.a(paramString, paramArrayOfByte, paramArrayOfByte.length, (short)0);
  }
  
  public void a(Map paramMap, ArrayList paramArrayList)
  {
    String str = " ";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
    for (str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString) {
      do
      {
        paramMap = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, paramArrayList, paramMap);
        paramMap.mMsg_A_ActionData = null;
        new Intent();
        paramArrayList = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ForwardRecentActivity.class);
        paramArrayList.putExtra("forward_type", -3);
        paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramArrayList, 21);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000));
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
  }
  
  public void a(boolean paramBoolean, ChatMessage paramChatMessage)
  {
    if (BaseChatItemLayout.jdField_b_of_type_Boolean == paramBoolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivity", 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
      return;
    }
    BaseChatItemLayout.jdField_b_of_type_Boolean = paramBoolean;
    MultiMsgManager.a().a(paramChatMessage, paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842089);
      if (android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        MultiMsgManager.a().a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if ((!ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
          break label305;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        label157:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297388).setVisibility(0);
        if (this.cm > 0)
        {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
          if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
          {
            paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
            paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, this.cm);
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
          }
        }
        if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (!android.text.TextUtils.isEmpty(this.jdField_i_of_type_AndroidWidgetTextView.getText().toString())) && (!"0".equals(this.jdField_i_of_type_AndroidWidgetTextView.getText().toString()))) {
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      return;
      this.jdField_c_of_type_JavaLangString = "";
      break;
      label305:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label157;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      V();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
      {
        paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
        if (this.cm == 0) {
          this.cm = paramChatMessage.bottomMargin;
        }
        paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, 0);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
      }
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      if (!paramBoolean1) {
        break label44;
      }
      q();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean2, false, false);
      b(true, paramBoolean2);
      this.jdField_d_of_type_Boolean = paramBoolean2;
      return;
      label44:
      r();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean3, paramBoolean1, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
      if ((paramBoolean1) || (paramBoolean2)) {
        break label46;
      }
    }
    label46:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      b(paramBoolean1, paramBoolean3);
      this.jdField_d_of_type_Boolean = paramBoolean3;
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    d(false);
    return true;
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("is_forward_MESSAGE", false)) {}
    String str;
    int m;
    do
    {
      return false;
      str = paramIntent.getStringExtra("uin");
      m = paramIntent.getIntExtra("uintype", -1);
      paramIntent = paramIntent.getStringExtra("troop_uin");
    } while ((str == null) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (m != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
    if (paramIntent == null) {}
    for (;;)
    {
      return true;
      if (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString)) {
        break;
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramMessageRecord.istroop))));
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnCreate start[" + hashCode() + "]");
    }
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    e();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    f();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
    c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    T();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), 1);
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnCreate_handleRequest", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime doOnCreate end");
      }
      return true;
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), 2);
    }
  }
  
  public void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue");
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() == this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()))
    {
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        i(true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004453", "0X8004453", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
  }
  
  public void ab()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.y = true;
  }
  
  public void ac()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    long l1 = System.currentTimeMillis();
    int m;
    if (this.jdField_e_of_type_Int == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      if (paramEditable.length() <= 0) {
        break label233;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(b());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      if ((paramEditable.length() > 1) && (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null))
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(paramEditable.toString());
        if ((localList != null) && (localList.size() >= 2)) {
          break label228;
        }
        m = ((EmoticonManagerImp)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager).a(paramEditable.toString());
        if (((localList != null) && (localList.size() > 0)) || (m > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setEmoticonKeywordList(localList, m);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l1));
      }
      return;
      label228:
      m = 0;
      break;
      label233:
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(c());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
      }
    }
  }
  
  public int b()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public SpannableString b()
  {
    if (this.jdField_c_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130837611);
      SpannableString localSpannableString = new SpannableString("发送");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_c_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_c_of_type_AndroidTextSpannableString;
  }
  
  @Deprecated
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start currenttime:" + System.currentTimeMillis());
    }
    String str;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)
    {
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      PicPreDownloadUtils.a(str);
      if ((str != null) && (str.length() > 3478)) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131366078, 1);
      }
    }
    else
    {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType == VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localObject = new ArrayList();
      str = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, (ArrayList)localObject);
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType == VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        localObject = str;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      }
      c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { localObject });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null);
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        localObject = str;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(3);
    b(false, false);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    R();
    if (paramInt2 == 3)
    {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(d());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
      if ((!this.p) && (paramInt2 != 4)) {
        break label153;
      }
      if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
      }
      paramInt1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
      if (paramInt1 == 0) {
        break label255;
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if ((paramInt1 == 5) || (paramInt1 == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
    }
    label153:
    label255:
    while ((paramInt2 == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null))
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(c());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
      break;
      if (paramInt2 != 0)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130837664);
        this.jdField_e_of_type_AndroidWidgetImageView.setSelected(false);
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((PatchedButton)localObject).setSelected(bool);
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(b());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
        break;
      }
    }
    Object localObject = (QQOperationViopTipTask)this.jdField_a_of_type_JavaUtilList.get(paramInt2 - 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a((QQOperationViopTipTask)localObject);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_d_of_type_AndroidWidgetTextView.setId(2131296338);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, (int)(44.0F * this.jdField_a_of_type_Float));
      localLayoutParams.rightMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_d_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427927));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(17.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131367595);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297347)).addView(this.jdField_d_of_type_AndroidWidgetTextView);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297388).setVisibility(8);
    a(true, paramChatMessage);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(CharSequence paramCharSequence)
  {
    j(0);
    this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().append(paramCharSequence);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
  }
  
  public void b(String paramString)
  {
    i(0);
  }
  
  @TargetApi(13)
  public void b(boolean paramBoolean)
  {
    int m = 0;
    int n = 1;
    if (!paramBoolean)
    {
      this.cq = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b()) {
        if (i1 == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          m = n;
          if (VersionUtils.c()) {
            m = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(m);
        }
      }
      label69:
      do
      {
        do
        {
          do
          {
            break label69;
            do
            {
              return;
            } while (i1 != 2);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            if (VersionUtils.c()) {}
            for (m = 6;; m = 0)
            {
              ((BaseActivity)localObject).setRequestedOrientation(m);
              return;
            }
            if (VersionUtils.f())
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
              n = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((n == 0) || (n == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (n != 0) {}
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(m);
                return;
                m = 8;
                continue;
                if (n == 0)
                {
                  m = 1;
                }
                else
                {
                  m = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (n != 1) {
                      m = 8;
                    }
                  }
                  else if (n == 1) {
                    m = 9;
                  } else {
                    m = 1;
                  }
                }
              }
            }
            m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((m != 0) && (m != 1)) {
              break;
            }
            if (i1 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(1);
              return;
            }
          } while (i1 != 2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(0);
          return;
        } while ((m != 2) && (m != 3));
        if (i1 == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(9);
          return;
        }
      } while (i1 != 2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(this.cq);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  protected SpannableString c()
  {
    if (this.jdField_b_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130837573);
      SpannableString localSpannableString = new SpannableString("语音输入");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_b_of_type_AndroidTextSpannableString;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(paramInt);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Intent paramIntent)
  {
    this.u = true;
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    k(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    d(paramIntent);
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    m(paramIntent);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    n(paramIntent);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession end");
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    MessageRecord localMessageRecord1 = MessageRecordFactory.a(paramChatMessage);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramChatMessage.uniseq);
    Object localObject1 = ((ArrayList)localObject2).iterator();
    MessageRecord localMessageRecord2;
    while (((Iterator)localObject1).hasNext())
    {
      localMessageRecord2 = (MessageRecord)((Iterator)localObject1).next();
      if ((localMessageRecord2 instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord2);
      }
    }
    localObject1 = new HashMap();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
      if (!((HashMap)localObject1).containsKey(localMessageRecord2.senderuin))
      {
        String str = MultiMsgManager.a().a(localMessageRecord2.senderuin, localMessageRecord2.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((HashMap)localObject1).put(localMessageRecord2.senderuin, str);
      }
    }
    MultiMsgManager.a().a((HashMap)localObject1, localMessageRecord1.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageRecord1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localArrayList, (HashMap)localObject1, localMessageRecord1, null);
  }
  
  public void c(String paramString)
  {
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    i(0);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 2;; m = 0)
    {
      a(m | 0x20000);
      return;
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0;
  }
  
  protected SpannableString d()
  {
    if (this.jdField_a_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130837585);
      SpannableString localSpannableString = new SpannableString("文字输入");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_a_of_type_AndroidTextSpannableString;
  }
  
  public void d()
  {
    k(6);
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366091));
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  public void d(Intent paramIntent) {}
  
  public void d(String paramString)
  {
    a(2, paramString, this.jdField_c_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new diz(this));
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null)
      {
        if (this.jdField_g_of_type_AndroidViewView == null) {
          this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903177, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_g_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840064));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b())) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a())) {
        return true;
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837544);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.moveTaskToBack(true);
    }
    if (this.jdField_c_of_type_Boolean) {}
    PendingIntent localPendingIntent = (PendingIntent)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
    if ((localPendingIntent != null) && ((localPendingIntent instanceof PendingIntent))) {}
    try
    {
      localPendingIntent.send();
      if (BaseChatItemLayout.jdField_b_of_type_Boolean)
      {
        a(false, null);
        return true;
      }
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatActivity", 4, localCanceledException.getMessage());
        }
      }
    }
    return false;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296742));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297026));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297037));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297036));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297347));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297357));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297361));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297390));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842090);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362879));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367787));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297001));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297389));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297034));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setActTAG("actFPSAIO");
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new dkc(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296719));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics())));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297032));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297033));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnTouchListener(new dhy(this));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297038);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297030));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new dij(this));
    this.jdField_a_of_type_AndroidWidgetEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    ((XEditTextEx)this.jdField_a_of_type_AndroidWidgetEditText).setOnPrivateIMECommandListener(new div(this));
    Object localObject = Build.MODEL;
    if ((localObject != null) && ((((String)localObject).startsWith("SH-")) || (((String)localObject).startsWith("SBM")) || (((String)localObject).startsWith("SHL")))) {}
    try
    {
      localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      int m = ((Integer)((Field)localObject).get(new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))).intValue();
      ((Field)localObject).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(m));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297029));
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297027));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297031));
      this.jdField_f_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366103));
      this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492916);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492912);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_i_of_type_Int = paramInt;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  protected void e(Intent paramIntent)
  {
    boolean bool2 = false;
    Object localObject = paramIntent.getExtras();
    boolean bool1;
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
      bool1 = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
      if (!paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false)) {
        break label238;
      }
      this.o = true;
    }
    for (;;)
    {
      if (this.o)
      {
        long l1 = System.currentTimeMillis();
        n();
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: " + (System.currentTimeMillis() - l1));
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("进入聊天信息界面");
      if (!this.o)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = (Intent)localObject;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365114).equals(localObject)) {
          paramIntent = "返回" + (String)localObject + "界面";
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
      return;
      if (localObject == null) {
        break;
      }
      this.jdField_c_of_type_Boolean = ((Bundle)localObject).getBoolean("isBack2Root");
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
      break;
      label238:
      if (bool1)
      {
        paramIntent = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (paramIntent == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366374);
        }
        for (;;)
        {
          this.o = false;
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368641, new Object[] { paramIntent });
        }
      }
      paramIntent = paramIntent.getExtras().getString("leftViewText");
      if (!this.jdField_c_of_type_Boolean)
      {
        bool1 = bool2;
        if (paramIntent != null)
        {
          bool1 = bool2;
          if (!paramIntent.contains(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366025))) {}
        }
      }
      else
      {
        bool1 = true;
      }
      this.o = bool1;
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long);
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    return h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dkb(this, null);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void f(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void f(Intent paramIntent)
  {
    long l1 = 0L;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363814, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    int m;
    Object localObject2;
    do
    {
      do
      {
        return;
        m = paramIntent.getIntExtra("forward_type", 2147483647);
      } while (m == 2147483647);
      paramIntent.removeExtra("forward_type");
      paramIntent.getExtras().remove("forward_type");
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("isBack2Root");
      localObject1 = paramIntent.getStringExtra("forward_filepath");
      switch (m)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      default: 
        return;
      case -3: 
      case 19: 
      case 20: 
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
        return;
      case -1: 
        paramIntent = paramIntent.getStringExtra("forward_text");
        if (!android.text.TextUtils.isEmpty(paramIntent)) {
          AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
        }
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
        return;
      case 0: 
        try
        {
          localObject2 = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
          if (paramIntent.getBooleanExtra("foward_editbar", false)) {
            break label464;
          }
          if ((localObject2 == null) || (((ForwardFileInfo)localObject2).d() != 3)) {
            break label442;
          }
          if ((!FileManagerUtil.a()) || (((ForwardFileInfo)localObject2).d() <= 5242880L)) {
            break label420;
          }
          FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131362469, 2131362465, new dhz(this, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2));
          return;
        }
        catch (Exception paramIntent) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivity", 2, "FORWARD_TYPE.FILE failed. " + paramIntent, paramIntent);
    return;
    label420:
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2, false);
    return;
    label442:
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2, false);
    return;
    label464:
    Object localObject1 = paramIntent.getParcelableArrayListExtra("fileinfo_array");
    long l2 = l1;
    if (localObject1 != null)
    {
      l2 = l1;
      if (((ArrayList)localObject1).size() > 0) {
        localObject2 = ((ArrayList)localObject1).iterator();
      }
    }
    for (;;)
    {
      l2 = l1;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ForwardFileInfo)((Iterator)localObject2).next();
        if (((ForwardFileInfo)localObject3).d() == 3) {
          l1 += ((ForwardFileInfo)localObject3).d();
        }
      }
      else
      {
        if ((FileManagerUtil.a()) && (l2 > 5242880L))
        {
          FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131362469, 2131362465, new dia(this, (ArrayList)localObject1, paramIntent));
          return;
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ForwardFileInfo)((Iterator)localObject1).next();
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, ((ForwardFileInfo)localObject2).a(), (ForwardFileInfo)localObject2, true);
        }
        boolean bool1 = paramIntent.getBooleanExtra("isFromShare", false);
        boolean bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
        Object localObject4;
        if (bool1)
        {
          if (bool2) {
            break;
          }
          localObject2 = paramIntent.getStringExtra("forward_download_image_task_key");
          localObject3 = paramIntent.getStringExtra("forward_download_image_org_uin");
          m = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          localObject4 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject4, (String)localObject3, l1, m, (String)localObject2);
          c(true);
          return;
        }
        paramIntent.putExtra("FORWARD_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramIntent.putExtra("SENDER_TROOP_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_SELF_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        m = paramIntent.getIntExtra("BUSI_TYPE", 1009);
        int n = paramIntent.getIntExtra("forward_source_uin_type", -1);
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "report forward! forwardFilePath = " + (String)localObject1 + ",forwardSourceUinType = " + n);
        }
        if (localObject1 != null)
        {
          l1 = paramIntent.getLongExtra("forward_image_width", 0L);
          l2 = paramIntent.getLongExtra("forward_image_height", 0L);
          int i1 = paramIntent.getIntExtra("forward_image_type", 0);
          StatisticConstants.a(AppConstants.aL + "#" + l1 + "#" + l2 + "#" + i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, n, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        paramIntent = PicBusiManager.a(m, paramIntent);
        localObject1 = PicBusiManager.a(3, m);
        ((PicReq)localObject1).a(paramIntent);
        PicBusiManager.a((PicReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1) == -1L) {
          break;
        }
        c(true);
        return;
        if (paramIntent.getBooleanExtra("isFromFavorites", false))
        {
          localObject4 = paramIntent.getExtras();
          if (localObject4 == null) {
            break;
          }
          paramIntent = ((Bundle)localObject4).getString("forward_latitude");
          localObject1 = ((Bundle)localObject4).getString("forward_longitude");
          localObject2 = ((Bundle)localObject4).getString("forward_location");
          localObject3 = ((Bundle)localObject4).getString("title");
          localObject4 = ((Bundle)localObject4).getString("summary");
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, "");
          return;
        }
        localObject1 = paramIntent.getStringExtra("forward_latitude");
        localObject2 = paramIntent.getStringExtra("forward_longitude");
        paramIntent = paramIntent.getStringExtra("forward_location");
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, paramIntent);
        return;
        localObject1 = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          switch (((ForwardUtils.SectionBase)localObject2).jdField_a_of_type_Int)
          {
          case 0: 
          default: 
            break;
          case -1: 
            if (!android.text.TextUtils.isEmpty(((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString)) {
              AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
            }
            ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString);
            break;
          case 1: 
            localObject3 = paramIntent.getStringExtra("forward_download_image_task_key");
            localObject4 = paramIntent.getStringExtra("forward_download_image_org_uin");
            m = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
            String str = paramIntent.getStringExtra("forward_download_image_server_path");
            l1 = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
            ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Pic)localObject2).jdField_b_of_type_JavaLangString, str, (String)localObject4, l1, m, (String)localObject3);
            c(true);
          }
        }
        if (2 == MarketFaceItemBuilder.n) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          paramIntent = MarketFaceItemBuilder.a;
          AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
          paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
    }
    for (;;)
    {
      this.jdField_d_of_type_JavaLangString = null;
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        j(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l1));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
      else if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
    }
  }
  
  public boolean f()
  {
    return true;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = new QQOperateTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ReaderTipsBar localReaderTipsBar = new ReaderTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = new FraudTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidOsHandler);
    SougouInputGrayTips localSougouInputGrayTips = new SougouInputGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    HongbaoKeywordGrayTips localHongbaoKeywordGrayTips = new HongbaoKeywordGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localReaderTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localSougouInputGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localHongbaoKeywordGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localVipSpecialCareGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsRedPacketShower = new RedPacketShower(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager = ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74));
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsRedPacketShower, 4);
  }
  
  public void g(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  protected void g(Intent paramIntent)
  {
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("ChatActivity", 2, "onNewIntent sessionInfo.curFriendUin is null and sessionInfo.curType " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + " troopUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + " sessionInfo.entrance " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    }
    h(paramIntent);
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setIntent(paramIntent);
    a(paramIntent, 2);
  }
  
  public void g(String paramString)
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, new dju(this), null);
      if (this.jdField_b_of_type_AndroidAppDialog != null) {
        ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297371)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365737));
      }
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296606)).setText(paramString);
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  public void h()
  {
    if (a())
    {
      ad();
      return;
    }
    ae();
  }
  
  public void h(int paramInt)
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366089));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427485), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427486)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "权限提示", localSpannableString, 0, 2131367708, null, null, new dix(this)).show();
  }
  
  public void h(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = paramIntent.getStringExtra("uin");
    int m = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != m))
    {
      this.l = false;
      if ((this.l) && (!localBundle.containsKey("forward_type"))) {
        break label96;
      }
      c(paramIntent);
    }
    label96:
    do
    {
      return;
      this.l = true;
      break;
      if ((this.jdField_c_of_type_Int != 0) || (bool))
      {
        c(true);
        return;
      }
    } while (localBundle.getLong("res_share_id", 0L) <= 0L);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
    case 16711689: 
    case 16711681: 
    case 16711683: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
    case 16711688: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 16711696: 
    case 24: 
    case 16711697: 
      for (;;)
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "read confirm send readconfirm");
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711689, 300000L);
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        continue;
        paramMessage = (String)paramMessage.obj;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage))
        {
          v();
          continue;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366406, 1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          continue;
          aj();
          continue;
          e(2);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
          if (this.jdField_c_of_type_Long == 0L) {
            g(2131165196);
          }
          AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
          continue;
          a(0, null, -1L);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
            continue;
            ai();
            continue;
            n(paramMessage.arg1);
            continue;
            b(paramMessage.arg1, paramMessage.arg2);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "delay MSG_START_VER_ANIM msg is handled,time is:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.obj);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16, 300L);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
            }
            if (this.jdField_b_of_type_AndroidViewView != null) {
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            }
            if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null)) {
              ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_b_of_type_AndroidViewViewGroup);
            }
            this.jdField_b_of_type_AndroidViewView = null;
            this.jdField_b_of_type_AndroidViewViewGroup = null;
            a(196612);
            continue;
            c(false);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d();
              continue;
              f((String)paramMessage.obj);
              continue;
              j(0);
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
              continue;
              v();
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366118, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getResources().getDimensionPixelSize(2131492923));
              }
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("nickCount", paramMessage.arg1 + "");
              StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "multiMsgNickTimeOut", false, 30000L, 0L, (HashMap)localObject1, "");
              continue;
              if (this.cn == 0) {
                break;
              }
              this.t = true;
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
    }
    for (paramMessage = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);; paramMessage = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage != null))
      {
        m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
        label920:
        if (m >= 0)
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m);
          if ((localObject2 != null) && ((localObject2 instanceof BaseChatItemLayout)))
          {
            localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2);
            localObject2 = AIOUtils.a((View)localObject2);
            if ((localObject2 == null) || (!((ChatMessage)localObject2).needVipBubble()) || (localObject1 == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).a == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_c_of_type_Int != BubbleUtils.a.jdField_c_of_type_Int) || (!paramMessage.a(((ChatMessage)localObject2).vipBubbleID))) {}
          }
        }
      }
      for (int m = 1; m != 0; m = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "MSG_BUBBLE_CACHE_UPDATE, real refresh");
        }
        a(196608);
        break;
        m -= 1;
        break label920;
        a(paramMessage);
        break;
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsColorRingTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsColorRingTipsBar = new ColorRingTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsColorRingTipsBar, new Object[0]);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsCommingRingTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsCommingRingTipsBar = new CommingRingTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsCommingRingTipsBar, new Object[0]);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar, new Object[0])) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.b().post(new djx(this));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar = new VipFunCallTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar, new Object[0]);
        break;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        break;
        boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_notice_key", false);
        if ((SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", false)) || (!bool)) {
          break;
        }
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        BaseApplicationImpl.a().startActivity(paramMessage);
        break;
        if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 2000L) {
          return true;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
          f(false);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a();
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 34), 5000L);
        break;
        f(true);
        break;
      }
    }
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297028).setVisibility(8);
  }
  
  public void i(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new diy(this, paramInt));
  }
  
  public void i(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_doOnNewIntent_updateUI");
    o(paramIntent);
    StartupTracker.a("AIO_doOnNewIntent_updateUI", "AIO_doOnNewIntent_updateData");
    g(paramIntent);
    StartupTracker.a("AIO_doOnNewIntent_updateData", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent end");
    }
    p(paramIntent);
  }
  
  public boolean i()
  {
    return a() == 1008;
  }
  
  public void j() {}
  
  @TargetApi(11)
  public void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.jdField_e_of_type_Int + "currenttime:" + System.currentTimeMillis());
    }
    Object localObject1;
    int m;
    Object localObject2;
    if (paramInt != this.jdField_e_of_type_Int)
    {
      if (paramInt != 1) {
        break label378;
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView == null)
      {
        localObject1 = new Button(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((Button)localObject1).setId(2131296333);
        ((Button)localObject1).setBackgroundResource(2130841750);
        ((Button)localObject1).setTextSize(2, 14.0F);
        ((Button)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427923));
        ((Button)localObject1).setText(2131366435);
        ((Button)localObject1).setOnTouchListener(this);
        m = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).indexOfChild(this.jdField_a_of_type_AndroidWidgetEditText);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, m, (ViewGroup.LayoutParams)localObject2);
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(d());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
      if (VersionUtils.e())
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(1.0F);
        this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = paramInt;
      R();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label378:
      if (paramInt != 2) {
        break;
      }
      localObject1 = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((TextView)localObject2).setId(2131296411);
        ((TextView)localObject2).setBackgroundResource(2130841717);
        ((TextView)localObject2).setTextSize(2, 20.0F);
        ((TextView)localObject2).setTextColor(-7829368);
        ((TextView)localObject2).setEnabled(false);
        ((TextView)localObject2).setGravity(17);
        if (this.jdField_a_of_type_AndroidWidgetEditText != null)
        {
          m = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).indexOfChild(this.jdField_a_of_type_AndroidWidgetEditText);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.height = AIOUtils.a(40.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          localLayoutParams.weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, m, localLayoutParams);
          this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject2);
        }
      }
      if (localObject1 != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((TroopGagMgr.SelfGagInfo)localObject1).jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) || (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0))
        {
          j(false);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(c());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e())
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(0.6F);
        this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    boolean bool;
    if (this.cj > 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) && (this.ci == 1))
      {
        bool = true;
        label806:
        ((PatchedButton)localObject1).setSelected(bool);
        localObject1 = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0) {
          break label983;
        }
        bool = true;
        label835:
        ((PatchedButton)localObject1).setSelected(bool);
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0) {
          break label988;
        }
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(b());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
      if (!VersionUtils.e()) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(1.0F);
      this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      break;
      bool = false;
      break label806;
      localObject1 = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {}
      for (bool = true;; bool = false)
      {
        ((PatchedButton)localObject1).setSelected(bool);
        break;
      }
      label983:
      bool = false;
      break label835;
      label988:
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(c());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
    }
  }
  
  protected void j(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "uploadPreviewPhoto");
    }
    ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(AlbumConstants.i, -1));
    Bundle localBundle = null;
    if (paramIntent != null) {
      localBundle = paramIntent.getExtras();
    }
    if (localBundle == null) {}
    do
    {
      int m;
      do
      {
        do
        {
          return;
          if (localBundle.getBoolean("deleteImage", false))
          {
            c(true);
            return;
          }
          m = paramIntent.getIntExtra(AlbumConstants.i, -1);
        } while ((m != 2) && (m != 1));
        paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
      } while ((paramIntent == null) || (paramIntent.isEmpty()));
      if (paramIntent.size() == 1)
      {
        if (m == 1)
        {
          c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 1);
          return;
        }
        c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 2);
        return;
      }
    } while (paramIntent.size() <= 1);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 4, "" + paramIntent.size());
  }
  
  public boolean j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY");
    }
    this.cp = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.cp == 1)
    {
      if (!((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).isActive(this.jdField_a_of_type_AndroidWidgetEditText))
      {
        this.y = false;
        return true;
      }
    }
    else if ((this.cp == 0) || ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)))
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText.getVisibility() == 0) {
        this.y = false;
      }
      return true;
    }
    return false;
  }
  
  public void k()
  {
    int m = 0;
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
    }
    ImageView localImageView = this.jdField_e_of_type_AndroidWidgetImageView;
    if (this.p) {
      m = 8;
    }
    localImageView.setVisibility(m);
  }
  
  public void k(int paramInt)
  {
    at();
    EmojiHomeUiPlugin.openEmojiHomePage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    if (6 == paramInt) {
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }
    while (9 != paramInt) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void l(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new djq(this));
    }
  }
  
  public void m()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void m(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(paramInt);
    }
  }
  
  void n()
  {
    Object localObject;
    int m;
    if (this.o)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject != null) && (!BaseChatItemLayout.jdField_b_of_type_Boolean))
      {
        m = ((QQMessageFacade)localObject).e();
        if (m <= 0) {
          break label157;
        }
        localObject = "" + m;
        if (m > 99) {
          localObject = "99+";
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366025) + "(" + (String)localObject + ")";
      }
    }
    for (String str = "返回" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366025) + "界面，" + m + "条未读";; str = "返回" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366025) + "界面")
    {
      a((String)localObject, str);
      return;
      label157:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366025);
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841831);
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131297357) {
      AIOUtils.jdField_h_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) && (m != 2131296443) && (m != 2131297033))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      f(true);
    }
    Object localObject1;
    Object localObject2;
    switch (m)
    {
    default: 
    case 2131297357: 
    case 2131297361: 
    case 2131296332: 
    case 2131297029: 
    case 2131296329: 
    case 2131297032: 
    case 2131297033: 
      long l1;
      long l2;
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
                if (BaseChatItemLayout.jdField_b_of_type_Boolean)
                {
                  a(false, null);
                  return;
                }
                H();
                return;
                m();
                if (QLog.isDevelopLevel()) {
                  QLog.d("reportEvent", 4, " curType : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", "", "");
                return;
                this.cg = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
                if (this.cg > 0)
                {
                  this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
                  this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1);
                }
                paramView.setVisibility(8);
                return;
                if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) || (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0))
                {
                  j(false);
                  if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 2) {
                    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                  }
                  this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
                  return;
                }
                i(true);
                return;
                localObject1 = (Intent)paramView.getTag();
                if (((Intent)localObject1).getExtras().getInt("uintype") == 0)
                {
                  localObject2 = ((Intent)localObject1).getExtras().getString("uin");
                  if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2))
                  {
                    ((Intent)localObject1).removeExtra("uintype");
                    ((Intent)localObject1).putExtra("uintype", 1003);
                  }
                }
                ((Intent)localObject1).putExtra("message_box_click", true);
                at();
                MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
                paramView.setVisibility(8);
                if (this.jdField_e_of_type_AndroidViewView != null) {
                  this.jdField_e_of_type_AndroidViewView.setVisibility(8);
                }
              } while (!((Intent)localObject1).getExtras().getBoolean("finishAIO"));
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
              return;
            } while (this.jdField_e_of_type_Int == 1);
            if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
            {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b();
            }
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
          } while (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0);
          j(false);
          return;
          if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4)) {
            break;
          }
          l1 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " onClick plus_btn start mInputStat = " + this.jdField_e_of_type_Int + " text.length " + this.jdField_a_of_type_AndroidWidgetEditText.getText().length() + "currenttime:" + System.currentTimeMillis());
          }
          b();
        } while (!QLog.isColorLevel());
        l2 = System.currentTimeMillis();
      } while (!QLog.isColorLevel());
      QLog.d("SendMsgBtn", 2, " onClick plus_btn end mInputStat = " + this.jdField_e_of_type_Int + "text.length" + this.jdField_a_of_type_AndroidWidgetEditText.getText().length() + "cast time :" + (l2 - l1));
      return;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(c());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369309));
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
          }
          f(true);
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903074, null));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131297027);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131296443);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_AndroidOsHandler);
        }
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.b();
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
          j(false);
        }
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(d());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369310));
        j(0);
      }
    case 2131296739: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!this.jdField_d_of_type_Boolean) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.f(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b();
        return;
      }
    case 2131297031: 
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837544);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837543);
      return;
    case 2131296338: 
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131365730, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      paramView = new ArrayList();
      localObject1 = new ArrayList();
      localObject2 = MultiMsgManager.a().jdField_a_of_type_JavaUtilHashMap;
      Object localObject3 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (((Boolean)((HashMap)localObject2).get(localEntry.getKey())).booleanValue()) {
          ((List)localObject1).add((ChatMessage)localEntry.getKey());
        }
      }
      if (((List)localObject1).size() == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366116, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (((List)localObject1).size() == 1)
      {
        paramView = (ChatMessage)((List)localObject1).get(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).a(2131298174, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg", 4, "checklist.size = " + ((List)localObject1).size());
        }
        if (((List)localObject1).size() == 0) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366115);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if (!paramView.contains(((ChatMessage)localObject3).senderuin)) {
            paramView.add(((ChatMessage)localObject3).senderuin);
          }
        }
        if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          Collections.sort((List)localObject1, this.jdField_b_of_type_JavaUtilComparator);
        }
      }
      MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
      MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramView);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(24);
        ((Message)localObject1).arg1 = paramView.size();
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 30000L);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramView);
        }
      }
    case 2131296443: 
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call enterPhotoPreivew");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
      PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).edit().putString("camera_photo_path", PlusPanelUtils.jdField_b_of_type_JavaLangString).commit();
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, (Intent)null, "callFromFastImage");
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(34);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
      return;
    }
    AIOUtils.jdField_h_of_type_Boolean = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "chat list onTouch() is called,action is:" + m);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      f(true);
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMotionEvent);
    }
    if (m == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return false;
      if ((m == 1) || (m == 3)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(true);
      }
    }
  }
  
  public void p()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558955);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localImageView.setBackgroundResource(2130837584);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void s()
  {
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (!i()) {
        break label28;
      }
    }
    label28:
    do
    {
      do
      {
        return;
        localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0))
        {
          localObject = ContactUtils.b((Friends)localObject);
          a(true);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
          return;
        }
      } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0);
      a(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  protected void t()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) || (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130842210);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setPadding(AIOUtils.a(32.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()), 0, 0, 0);
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130841709);
    }
  }
  
  public void u()
  {
    StartupTracker.a(null, "AIO_doOnDestroy");
    this.co = 0;
    this.cg = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c());
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
    }
    ae();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.b();
    U();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
    }
    a(false, null);
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
    }
    ChatActivityUtils.a();
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_f_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_j_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_k_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_k_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    }
    MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
    MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a();
    AITranslator.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
    MultiMsgManager.a().a();
    AioAnimationDetector.a().a();
    ThridAppShareHelper.a().a();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive(this.jdField_a_of_type_AndroidWidgetEditText))
    {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
      v = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null) {
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsRedPacketShower);
    }
    PerformanceReportUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.jdField_a_of_type_Long = 0L;
    StartupTracker.a("AIO_doOnDestroy", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnDestroy end[" + hashCode() + "]");
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    label557:
    label602:
    label737:
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
              if (!(paramObject instanceof MessageRecord)) {
                break label602;
              }
              if (!(paramObject instanceof ChatMessage)) {
                break label557;
              }
              paramObservable = (MessageRecord)paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("ChatActivity", 2, "update mr.msgseq" + paramObservable.msgseq + ",time is:" + System.currentTimeMillis());
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
                AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              }
              if (paramObservable.isSendFromLocal()) {
                break;
              }
            } while ((paramObservable.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)));
            if (a(paramObservable))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
              {
                if ((!paramObservable.isread) && ((paramObservable instanceof MessageForShakeWindow)))
                {
                  paramObservable = (MessageForShakeWindow)paramObservable;
                  paramObservable.parse();
                  if ((paramObservable.mShakeWindowMsg != null) && (paramObservable.mShakeWindowMsg.onlineFlag == 1))
                  {
                    if (this.jdField_b_of_type_JavaUtilList == null) {
                      this.jdField_b_of_type_JavaUtilList = new ArrayList();
                    }
                    this.jdField_b_of_type_JavaUtilList.add(paramObservable);
                  }
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                this.r = true;
                this.s = true;
                a(196608);
              }
              this.jdField_j_of_type_Boolean = true;
            }
            for (;;)
            {
              n();
              return;
              if ((paramObservable.istroop == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.senderuin)) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
              {
                if ((String.valueOf(AppConstants.ae).equalsIgnoreCase(paramObservable.frienduin)) && (!paramObservable.isread))
                {
                  a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
                }
                else
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
                  {
                    this.s = true;
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    a(196608);
                  }
                  this.jdField_j_of_type_Boolean = true;
                }
              }
              else if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && (!paramObservable.isread)) {
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            this.r = true;
            this.jdField_j_of_type_Boolean = true;
            c(true);
          } while ((!(paramObservable instanceof MessageForStructing)) || ((paramObservable.istroop != 1) && (paramObservable.istroop != 3000) && (paramObservable.istroop != 0)) || (!"viewMultiMsg".equals(((MessageForStructing)paramObservable).structingMsg.mMsgAction)));
          MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop, paramObservable.uniseq, true);
          return;
          paramObservable = (MessageRecord)paramObject;
          if (((paramObject instanceof DataLineMsgRecord)) && (!paramObservable.isread) && (!paramObservable.isSendFromLocal())) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
          }
          n();
          return;
          if (!(paramObject instanceof QQMessageFacade.RefreshMessageContext)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = ((QQMessageFacade.RefreshMessageContext)paramObject);
          paramObservable = (ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.a())) || (this.jdField_b_of_type_Long != paramObservable.a()) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_d_of_type_Boolean));
        long l1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean)
        {
          this.q = bool;
          l1 = this.jdField_b_of_type_Long + 300L - SystemClock.uptimeMillis();
          if (l1 <= 0L) {
            break label737;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dih(this), l1);
          return;
          bool = false;
          break;
          l1 = 0L;
        }
      } while (!(paramObject instanceof QQMessageFacade.MessageNotifyParam));
      paramObservable = (QQMessageFacade.MessageNotifyParam)paramObject;
    } while ((!paramObservable.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramObservable.jdField_b_of_type_Int != 0));
    c(false);
  }
  
  public void v()
  {
    x();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void w()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, localIntent);
    }
  }
  
  public void x()
  {
    ag();
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localFileTransferManager != null) {
        localFileTransferManager.b();
      }
    }
  }
  
  public void y()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnStart end");
    }
  }
  
  public void z()
  {
    this.jdField_i_of_type_Boolean = false;
    at();
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      S();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnStop end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */