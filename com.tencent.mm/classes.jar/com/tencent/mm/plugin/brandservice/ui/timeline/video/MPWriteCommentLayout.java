package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.bizui.widget.BizKeyboardLinearLayout;
import com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Landroid/widget/TextView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "fixHeight", "isDoingGetMyComment", "", "isHaokan", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "root", "sayFooter", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPSmileyFooter;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "adjustContentHeight", "", "newMarginBottom", "closeComment", "contentEtOnClick", "dissMissProgressDlg", "doAppMsgOperateComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "fixKeyBoardMargin", "getAppMsgCommentList", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgOperateComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onDeleteComment", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "saveRootHeight", "height", "setData", "show", "showLayout", "showProgressDlg", "wording", "showToast", "bundle", "Landroid/os/Bundle;", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "BizVideoMyCommentItemAdapter", "Companion", "MPWriteCommentLayoutCallback", "plugin-brandservice_release"})
public final class MPWriteCommentLayout
  extends BizKeyboardLinearLayout
{
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  public static final MPWriteCommentLayout.b khu;
  private p ehb;
  private int fgh;
  private View gvJ;
  private WeakReference<MPWriteCommentLayout> jMl;
  private int kbN;
  private int kfv;
  private int kfx;
  private View kgr;
  private BizKeyboardLinearLayout khc;
  MPSmileyFooter khd;
  private TextView khe;
  private Button khf;
  public MMEditText khg;
  private ListView khh;
  private View khi;
  private TextView khj;
  private TextView khk;
  private MPWriteCommentLayout.a khl;
  int khm;
  private boolean khn;
  private int kho;
  private int khp;
  private long khq;
  private MPWriteCommentLayout.c khr;
  private boolean khs;
  private int kht;
  private int scene;
  private String title;
  private String url;
  
  static
  {
    AppMethodBeat.i(152938);
    khu = new MPWriteCommentLayout.b((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(152938);
  }
  
  public MPWriteCommentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152937);
    this.khm = -1;
    this.url = "";
    this.title = "";
    this.jMl = new WeakReference(this);
    paramAttributeSet = View.inflate(paramContext, 2130970313, (ViewGroup)this);
    if (paramAttributeSet == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.bizui.widget.BizKeyboardLinearLayout");
      AppMethodBeat.o(152937);
      throw paramContext;
    }
    this.khc = ((BizKeyboardLinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131826395);
    j.p(paramAttributeSet, "findViewById(R.id.biz_video_my_comment_list)");
    this.khh = ((ListView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826387);
    j.p(paramAttributeSet, "findViewById(R.id.mp_write_comment_root)");
    this.kgr = paramAttributeSet;
    paramAttributeSet = findViewById(2131826388);
    j.p(paramAttributeSet, "findViewById(R.id.mp_video_comment_action_layout)");
    this.gvJ = paramAttributeSet;
    paramAttributeSet = findViewById(2131826389);
    j.p(paramAttributeSet, "findViewById(R.id.mp_video_comment_cancel)");
    this.khe = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826394);
    j.p(paramAttributeSet, "findViewById(R.id.biz_video_my_comment_tv)");
    this.khj = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826390);
    j.p(paramAttributeSet, "findViewById(R.id.mp_video_my_comment_title)");
    this.khk = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826392);
    j.p(paramAttributeSet, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.khi = paramAttributeSet;
    paramAttributeSet = findViewById(2131826391);
    j.p(paramAttributeSet, "findViewById(R.id.mp_video_comment_ok)");
    this.khf = ((Button)paramAttributeSet);
    paramAttributeSet = findViewById(2131826393);
    j.p(paramAttributeSet, "findViewById(R.id.mp_video_comment_et)");
    this.khg = ((MMEditText)paramAttributeSet);
    paramAttributeSet = findViewById(2131826396);
    j.p(paramAttributeSet, "findViewById(R.id.mp_smiley_footer)");
    this.khd = ((MPSmileyFooter)paramAttributeSet);
    this.khd.setMMEditText(this.khg);
    this.khd.setVisibility(8);
    this.khg.setOnClickListener((View.OnClickListener)new MPWriteCommentLayout.1(this));
    this.khg.setOnLongClickListener((View.OnLongClickListener)new MPWriteCommentLayout.2(this));
    this.khc.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(152895);
        j.p(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousView = this.khv;
          if (paramAnonymousView.khm != -3) {
            break label72;
          }
          paramAnonymousView = paramAnonymousView.getContext();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(152895);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
        }
        for (;;)
        {
          AppMethodBeat.o(152895);
          return true;
          label72:
          if ((paramAnonymousView.khd.bac()) && (paramAnonymousView.Pk())) {
            paramAnonymousView.khd.bae();
          } else {
            paramAnonymousView.hide();
          }
        }
      }
    });
    this.kgr.setOnClickListener((View.OnClickListener)4.khw);
    int i = getRootHeight();
    if (i > 0)
    {
      paramAttributeSet = this.kgr.getLayoutParams();
      if (paramAttributeSet == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(152937);
        throw paramContext;
      }
      paramAttributeSet.height = i;
      this.kgr.setLayoutParams(paramAttributeSet);
    }
    this.khe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152897);
        this.khv.hide();
        AppMethodBeat.o(152897);
      }
    });
    this.khf.setOnClickListener((View.OnClickListener)new MPWriteCommentLayout.6(this, paramContext));
    this.khg.addTextChangedListener((TextWatcher)new MPWriteCommentLayout.7(this));
    paramContext = this.khf;
    paramAttributeSet = this.khg.getText();
    j.p(paramAttributeSet, "contentEt.text");
    if (((CharSequence)paramAttributeSet).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext.setEnabled(bool);
      AppMethodBeat.o(152937);
      return;
    }
  }
  
  private final void aZI()
  {
    AppMethodBeat.i(152923);
    View localView = this.khi;
    Context localContext = getContext();
    j.p(localContext, "context");
    localView.setBackgroundColor(localContext.getResources().getColor(2131689758));
    this.khj.setVisibility(8);
    AppMethodBeat.o(152923);
  }
  
  private final void aZL()
  {
    AppMethodBeat.i(152931);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new f(this));
    this.kgr.clearAnimation();
    this.kgr.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(152931);
  }
  
  private final int getRootHeight()
  {
    AppMethodBeat.i(152928);
    as localas = as.eu("brandService", 1);
    if (localas != null)
    {
      int i = localas.getInt("MPWriteCommentRootHeight", 0);
      AppMethodBeat.o(152928);
      return i;
    }
    AppMethodBeat.o(152928);
    return 0;
  }
  
  private final void show()
  {
    AppMethodBeat.i(152929);
    this.kgr.clearAnimation();
    setVisibility(0);
    MPWriteCommentLayout.c localc = this.khr;
    if (localc != null)
    {
      localc.onShow();
      AppMethodBeat.o(152929);
      return;
    }
    AppMethodBeat.o(152929);
  }
  
  public final void Ht(String paramString)
  {
    AppMethodBeat.i(152935);
    Object localObject = getContext();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(152935);
      throw paramString;
    }
    if (((Activity)localObject).isFinishing())
    {
      AppMethodBeat.o(152935);
      return;
    }
    aZM();
    if (this.ehb != null)
    {
      localObject = this.ehb;
      if (localObject == null) {
        j.ebi();
      }
      if (!((p)localObject).isShowing())
      {
        paramString = this.ehb;
        if (paramString != null)
        {
          paramString.show();
          AppMethodBeat.o(152935);
          return;
        }
        AppMethodBeat.o(152935);
        return;
      }
    }
    this.ehb = h.b(getContext(), paramString, true, (DialogInterface.OnCancelListener)MPWriteCommentLayout.i.khP);
    AppMethodBeat.o(152935);
  }
  
  final boolean Pk()
  {
    AppMethodBeat.i(152932);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(152932);
      return true;
    }
    AppMethodBeat.o(152932);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    this.scene = paramInt1;
    this.kbN = paramInt2;
    this.fgh = paramInt3;
    this.kfv = paramInt4;
    this.url = paramString1;
    this.title = paramString2;
  }
  
  public final void a(eo parameo)
  {
    AppMethodBeat.i(152934);
    j.q(parameo, "req");
    parameo.scene = this.scene;
    parameo.wqc = this.kbN;
    parameo.url = this.url;
    parameo.title = this.title;
    parameo.wqJ = System.currentTimeMillis();
    parameo.wqa = this.fgh;
    parameo.session_id = this.kfx;
    parameo.wqb = this.kfv;
    parameo.wqd = this.khq;
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    locala.a((a)parameo);
    locala.b((a)new ep());
    locala.rl("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    locala.kT(2617);
    locala.kU(0);
    locala.kV(0);
    com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new MPWriteCommentLayout.d(this));
    Ht(getContext().getString(2131297112));
    AppMethodBeat.o(152934);
  }
  
  public final void aZJ()
  {
    AppMethodBeat.i(152924);
    this.khc.setOnkbdStateListener((KeyboardLinearLayout.a)new g(this));
    AppMethodBeat.o(152924);
  }
  
  public final boolean aZK()
  {
    AppMethodBeat.i(152926);
    if ((this.khd.bac()) && (Pk()))
    {
      this.khd.bae();
      AppMethodBeat.o(152926);
      return true;
    }
    if ((this.khm != -3) && (Pk()))
    {
      hide();
      AppMethodBeat.o(152926);
      return true;
    }
    AppMethodBeat.o(152926);
    return false;
  }
  
  public final void aZM()
  {
    AppMethodBeat.i(152936);
    if (this.ehb != null)
    {
      Object localObject = this.ehb;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((p)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          j.ebi();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.ehb;
        if (localObject == null) {
          break;
        }
        ((p)localObject).dismiss();
        AppMethodBeat.o(152936);
        return;
      }
    }
    AppMethodBeat.o(152936);
  }
  
  public final void fQ(boolean paramBoolean)
  {
    AppMethodBeat.i(152925);
    this.khn = paramBoolean;
    show();
    postDelayed((Runnable)new MPWriteCommentLayout.h(this), 10L);
    Object localObject = this.khi;
    Context localContext = getContext();
    j.p(localContext, "context");
    ((View)localObject).setBackgroundColor(localContext.getResources().getColor(2131689758));
    if (paramBoolean)
    {
      this.khj.setVisibility(8);
      this.khk.setText((CharSequence)getContext().getString(2131297737));
      this.khg.setHint(2131297739);
      this.khf.setText(2131297067);
      localObject = this.khf;
      localContext = getContext();
      j.p(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(2130837990));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.khg.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(152925);
      return;
    }
    getAppMsgCommentList();
    this.khk.setText((CharSequence)getContext().getString(2131297746));
    this.khg.setHint(2131297748);
    this.khf.setText(2131297729);
    localObject = this.khf;
    localContext = getContext();
    j.p(localContext, "context");
    ((Button)localObject).setBackground(localContext.getResources().getDrawable(2130837988));
    localObject = (InputFilter)new InputFilter.LengthFilter(600);
    this.khg.setFilters(new InputFilter[] { localObject });
    AppMethodBeat.o(152925);
  }
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(152933);
    ef localef = new ef();
    localef.url = this.url;
    if (this.khs)
    {
      AppMethodBeat.o(152933);
      return;
    }
    localef.offset = this.kht;
    if (this.kht == -1)
    {
      ab.i(TAG, "no more my comment");
      AppMethodBeat.o(152933);
      return;
    }
    this.khs = true;
    localef.knS = 2;
    localef.scene = this.scene;
    localef.wqc = this.kbN;
    localef.wqa = this.fgh;
    localef.session_id = this.kfx;
    localef.wqb = this.kfv;
    localef.wqd = this.khq;
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    locala.a((a)localef);
    locala.b((a)new eg());
    locala.rl("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.kT(2866);
    locala.kU(0);
    locala.kV(0);
    com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new MPWriteCommentLayout.e(this));
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(7);
    AppMethodBeat.o(152933);
  }
  
  public final MPWriteCommentLayout.c getCallback()
  {
    return this.khr;
  }
  
  public final long getCommentTopicId()
  {
    return this.khq;
  }
  
  public final int getEnterId()
  {
    return this.kfv;
  }
  
  public final int getItemShowType()
  {
    return this.fgh;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.khp;
  }
  
  public final int getMyCommentOffset()
  {
    return this.kht;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.kbN;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.kfx;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public final WeakReference<MPWriteCommentLayout> getWeakThis$plugin_brandservice_release()
  {
    return this.jMl;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(152930);
    if (!Pk())
    {
      AppMethodBeat.o(152930);
      return;
    }
    if (this.khd.bad()) {
      this.khd.bae();
    }
    aZL();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(152930);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).hideVKB();
    this.kht = 0;
    localObject = this.khl;
    if (localObject != null) {
      ((MPWriteCommentLayout.a)localObject).clear();
    }
    localObject = this.khr;
    if (localObject != null)
    {
      ((MPWriteCommentLayout.c)localObject).onHide();
      AppMethodBeat.o(152930);
      return;
    }
    AppMethodBeat.o(152930);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(152927);
    if (this.khd != null) {
      this.khd.release();
    }
    aZM();
    AppMethodBeat.o(152927);
  }
  
  public final void setCallback(MPWriteCommentLayout.c paramc)
  {
    this.khr = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.khq = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.kfv = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.fgh = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.khp = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.kht = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.kbN = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.kfx = paramInt;
  }
  
  public final void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public final void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public final void setWeakThis$plugin_brandservice_release(WeakReference<MPWriteCommentLayout> paramWeakReference)
  {
    AppMethodBeat.i(152922);
    j.q(paramWeakReference, "<set-?>");
    this.jMl = paramWeakReference;
    AppMethodBeat.o(152922);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$Companion;", "", "()V", "TAG", "", "option", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getOption", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "setOption", "(Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;)V", "plugin-brandservice_release"})
  public static final class a$c {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a$d
    implements View.OnClickListener
  {
    a$d(MPWriteCommentLayout.a parama, kx paramkx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(152903);
      new c.a(MPWriteCommentLayout.a.a(this.khF)).avm(MPWriteCommentLayout.a.a(this.khF).getString(2131297730)).avn("").Rk(MPWriteCommentLayout.a.a(this.khF).getResources().getColor(2131689605)).Ri(2131297018).a((DialogInterface.OnClickListener)new a(this)).Rj(2131297827).aLZ().show();
      AppMethodBeat.o(152903);
    }
    
    @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class a
      implements DialogInterface.OnClickListener
    {
      a(MPWriteCommentLayout.a.d paramd) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(152902);
        paramDialogInterface = new eo();
        paramDialogInterface.wqK = this.khL.khK.wqK;
        paramDialogInterface.knS = 2;
        this.khL.khF.khy.a(paramDialogInterface);
        com.tencent.mm.plugin.webview.ui.tools.b.Ko(13);
        AppMethodBeat.o(152902);
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class a$d$a
    implements DialogInterface.OnClickListener
  {
    a$d$a(MPWriteCommentLayout.a.d paramd) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(152902);
      paramDialogInterface = new eo();
      paramDialogInterface.wqK = this.khL.khK.wqK;
      paramDialogInterface.knS = 2;
      this.khL.khF.khy.a(paramDialogInterface);
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(13);
      AppMethodBeat.o(152902);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-brandservice_release"})
  public static final class f
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(152915);
      j.q(paramAnimation, "ani");
      paramAnimation = this.khv.getWeakThis$plugin_brandservice_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout");
        AppMethodBeat.o(152915);
        throw paramAnimation;
      }
      ((MPWriteCommentLayout)paramAnimation).setVisibility(8);
      MPWriteCommentLayout.c(this.khv).clearAnimation();
      AppMethodBeat.o(152915);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  static final class g
    implements KeyboardLinearLayout.a
  {
    g(MPWriteCommentLayout paramMPWriteCommentLayout) {}
    
    public final void sJ(int paramInt)
    {
      AppMethodBeat.i(152918);
      MPWriteCommentLayout.b localb = MPWriteCommentLayout.khu;
      ab.i(MPWriteCommentLayout.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = MPWriteCommentLayout.a(this.khv).getKeyBoardHeight();
        if (i > 0)
        {
          MPWriteCommentLayout.a(this.khv, i);
          MPWriteCommentLayout.a(this.khv, i);
        }
        new ak().postDelayed((Runnable)new MPWriteCommentLayout.g.1(this), 10L);
      }
      for (;;)
      {
        MPWriteCommentLayout.b(this.khv, paramInt);
        AppMethodBeat.o(152918);
        return;
        MPWriteCommentLayout.a(this.khv, 0);
        MPWriteCommentLayout.a(this.khv, 0);
        new ak().postDelayed((Runnable)new MPWriteCommentLayout.g.2(this), 10L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout
 * JD-Core Version:    0.7.0.1
 */