package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificatePositiveWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/GyroscopeSensorController$SensorChangeListener;", "root", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "serive", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;)V", "certificateAcceptHead", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "certificateAcceptLayout", "Landroid/widget/LinearLayout;", "certificateAcceptName", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/GradientTextView;", "certificateEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "certificateErrorText", "Landroid/widget/TextView;", "certificateGyroscopeLight", "Landroid/view/View;", "certificateLayoutPositive", "Landroid/widget/RelativeLayout;", "getCertificateLayoutPositive", "()Landroid/widget/RelativeLayout;", "setCertificateLayoutPositive", "(Landroid/widget/RelativeLayout;)V", "certificateNumber", "certificatePoi", "certificatePositiveContent", "getCertificatePositiveContent", "setCertificatePositiveContent", "certificateSettingBtn", "Landroid/widget/Button;", "certificateStamp", "getCertificateStamp", "()Landroid/widget/ImageView;", "setCertificateStamp", "(Landroid/widget/ImageView;)V", "certificateStep", "certificateTorch", "getCertificateTorch", "setCertificateTorch", "certificateTorchLight", "getCertificateTorchLight", "setCertificateTorchLight", "certificateTorchLightBlock1", "certificateTorchLightBlock2", "certificateUpdateContent", "currentY", "", "defaultTransityY", "", "gyroscopeSensorController", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/GyroscopeSensorController;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getSerive", "()Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "settingLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "settintgBottomMargin", "setttingPosition", "", "userName", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateTextView;", "adjustConfirmBtnLayout", "", "show", "height", "adjustLayout", "getEditText", "getLayoutView", "getSettingLiveData", "hideKVB", "initView", "keyboardChange", "onChanged", "t", "onClick", "v", "onSensorChange", "xAngle", "yAngle", "zAngle", "registerGyroscopeSensor", "reset", "resetScroll", "view", "resetSensor", "setCertificateSettingBtnEnable", "isEnable", "setLightY", "value", "setRotationY", "setScrollX", "setSettingButton", "btn", "setTransitionY", "settingBtnClick", "showKVB", "unMount", "unRegisterGyroscopeSensor", "updateLayoutView", "updateModeLayout", "showMode", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateLayout$CertificateMode;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  extends a<com.tencent.mm.plugin.finder.live.olympic.certificate.data.a>
  implements com.tencent.mm.plugin.finder.live.olympic.certificate.a.b
{
  public static final g.a CQM;
  private static float CRk;
  private static float CRl;
  private static float CRm;
  private final com.tencent.mm.plugin.finder.live.olympic.certificate.b CPS;
  private RelativeLayout CQN;
  MMEditText CQO;
  private TextView CQP;
  private CertificateTextView CQQ;
  private GradientTextView CQR;
  private GradientTextView CQS;
  private GradientTextView CQT;
  private LinearLayout CQU;
  private ImageView CQV;
  private GradientTextView CQW;
  private ImageView CQX;
  private ImageView CQY;
  private View CQZ;
  Button CQb;
  public final x<String> CRa;
  private final com.tencent.mm.plugin.finder.live.olympic.certificate.a CRb;
  private final int CRc;
  ImageView CRd;
  RelativeLayout CRe;
  private ImageView CRf;
  private ImageView CRg;
  RelativeLayout CRh;
  private final int[] CRi;
  private int CRj;
  private final i lKz;
  private boolean mJk;
  private float pxl;
  
  static
  {
    AppMethodBeat.i(361057);
    CQM = new g.a((byte)0);
    com.tencent.mm.plugin.finder.live.olympic.util.a locala = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    CRk = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(16);
    locala = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    CRl = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(56);
    locala = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    CRm = com.tencent.mm.plugin.finder.live.olympic.util.a.OT(70);
    AppMethodBeat.o(361057);
  }
  
  public g(ViewGroup paramViewGroup, q paramq, com.tencent.mm.plugin.finder.live.olympic.certificate.b paramb)
  {
    super(paramViewGroup, paramq);
    AppMethodBeat.i(360988);
    this.CPS = paramb;
    this.CQN = ((RelativeLayout)paramViewGroup.findViewById(p.e.BBY));
    this.CQO = ((MMEditText)paramViewGroup.findViewById(p.e.BJu));
    this.CQP = ((TextView)paramViewGroup.findViewById(p.e.BCQ));
    this.CQQ = ((CertificateTextView)paramViewGroup.findViewById(p.e.BJv));
    this.CQR = ((GradientTextView)paramViewGroup.findViewById(p.e.BJw));
    this.CQS = ((GradientTextView)paramViewGroup.findViewById(p.e.BJx));
    this.CQT = ((GradientTextView)paramViewGroup.findViewById(p.e.BJy));
    this.CQU = ((LinearLayout)paramViewGroup.findViewById(p.e.BJq));
    this.CQV = ((ImageView)paramViewGroup.findViewById(p.e.BJp));
    this.CQW = ((GradientTextView)paramViewGroup.findViewById(p.e.BJr));
    this.CQX = ((ImageView)paramViewGroup.findViewById(p.e.BQh));
    this.CQY = ((ImageView)paramViewGroup.findViewById(p.e.BQi));
    this.CQZ = paramViewGroup.findViewById(p.e.BDa);
    this.CRa = new x();
    paramb = paramViewGroup.getContext();
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(360988);
      throw paramViewGroup;
    }
    this.lKz = new i((Activity)paramb);
    paramb = paramViewGroup.getContext();
    s.s(paramb, "root.context");
    this.CRb = new com.tencent.mm.plugin.finder.live.olympic.certificate.a(paramb, (com.tencent.mm.plugin.finder.live.olympic.certificate.a.b)this);
    this.CRc = OT(30);
    this.CRd = ((ImageView)paramViewGroup.findViewById(p.e.BQm));
    this.CRe = ((RelativeLayout)paramViewGroup.findViewById(p.e.BQe));
    this.CRf = ((ImageView)paramViewGroup.findViewById(p.e.BJz));
    this.CRg = ((ImageView)paramViewGroup.findViewById(p.e.BJB));
    this.CRh = ((RelativeLayout)paramViewGroup.findViewById(p.e.BBX));
    qQ(false);
    this.CQO.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(360889);
        g.b(this.CRn).setText((CharSequence)"");
        g localg = this.CRn;
        paramAnonymousEditable = (CharSequence)String.valueOf(paramAnonymousEditable);
        int i;
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label72;
          }
        }
        label72:
        for (boolean bool = true;; bool = false)
        {
          localg.qQ(bool);
          AppMethodBeat.o(360889);
          return;
          i = 0;
          break;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.CRa.a(paramq, new g..ExternalSyntheticLambda0(this));
    this.lKz.afIL = new g..ExternalSyntheticLambda1(this);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.CRd;
    s.s(paramViewGroup, "certificateStamp");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramViewGroup, b.j.ahpi, p.d.BzD);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.CRf;
    s.s(paramViewGroup, "certificateTorch");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramViewGroup, b.j.ahpj, p.d.BzG);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.CRg;
    s.s(paramViewGroup, "certificateTorchLight");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramViewGroup, b.j.ahpk, p.d.BzH);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.mJe.findViewById(p.e.BQf);
    s.s(paramViewGroup, "root.findViewById<ImageV…icate_layout_positive_bg)");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a((ImageView)paramViewGroup, b.j.ahpg, p.d.BzA);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.CQX;
    s.s(paramViewGroup, "certificateTorchLightBlock1");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramViewGroup, b.j.ahpl, p.d.BzB);
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.CQY;
    s.s(paramViewGroup, "certificateTorchLightBlock2");
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramViewGroup, b.j.ahpl, p.d.BzB);
    getLayoutView().setCameraDistance(this.mJe.getContext().getResources().getDisplayMetrics().density * 5000.0F);
    this.CQZ.setTranslationY(-this.CRc);
    ((GradientTextView)this.mJe.findViewById(p.e.BJt)).eod();
    ((GradientTextView)this.mJe.findViewById(p.e.BJs)).eoe();
    enQ();
    this.CRi = new int[2];
    AppMethodBeat.o(360988);
  }
  
  private static final void a(g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(361025);
    s.u(paramg, "this$0");
    Log.i("BaseOlympicCertificateW", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (paramInt > 0)
    {
      paramBoolean = true;
      if (paramg.mJk == paramBoolean) {
        break label322;
      }
      paramg.mJk = paramBoolean;
      if (paramg.CQb != null)
      {
        localObject1 = paramg.CQb;
        if (localObject1 != null) {
          break label102;
        }
      }
    }
    label102:
    for (Object localObject1 = null;; localObject1 = ((Button)localObject1).getLayoutParams())
    {
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label110;
      }
      AppMethodBeat.o(361025);
      return;
      paramBoolean = false;
      break;
    }
    label110:
    if (paramg.CRi[1] == 0)
    {
      localObject1 = paramg.CQb;
      if (localObject1 != null)
      {
        ((Button)localObject1).getLocationOnScreen(paramg.CRi);
        paramg.CRj = (paramg.getScreenHeight() - (paramg.CRi[1] + ((Button)localObject1).getHeight()));
        Log.i("BaseOlympicCertificateW", s.X("adjustConfirmBtnLayout bottomMargin: ", Integer.valueOf(paramg.CRj)));
      }
    }
    paramInt = OT(40);
    localObject1 = paramg.CQb;
    label204:
    View localView;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof ViewGroup)) {
        break label263;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {
        break label322;
      }
      localView = (View)paramg.CQb;
      localObject2 = paramg.CQb;
      if (localObject2 != null) {
        break label268;
      }
    }
    label263:
    label268:
    for (Object localObject2 = null;; localObject2 = ((Button)localObject2).getLayoutParams())
    {
      if (localObject2 != null) {
        break label278;
      }
      paramg = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(361025);
      throw paramg;
      localObject1 = ((Button)localObject1).getParent();
      break;
      localObject1 = null;
      break label204;
    }
    label278:
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    if (paramBoolean) {
      paramInt -= paramg.getScreenWidth() - paramg.CRj;
    }
    for (;;)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = paramInt;
      paramg = ah.aiuX;
      ((ViewGroup)localObject1).updateViewLayout(localView, (ViewGroup.LayoutParams)localObject2);
      label322:
      AppMethodBeat.o(361025);
      return;
    }
  }
  
  private static final void a(g paramg, String paramString)
  {
    AppMethodBeat.i(361008);
    s.u(paramg, "this$0");
    Log.i("BaseOlympicCertificateW", s.X("receive OlympicCgiException: ", paramString));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramg.CQP.setText((CharSequence)paramString);
        paramg.qQ(false);
      }
      paramString = (CharSequence)paramg.CQO.getText().toString();
      if ((paramString != null) && (paramString.length() != 0)) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramg.CQP.setText((CharSequence)"");
      }
      AppMethodBeat.o(361008);
      return;
      i = 0;
      break;
    }
  }
  
  private final void enZ()
  {
    AppMethodBeat.i(360999);
    this.pxl = 0.0F;
    this.CRe.setRotationY(0.0F);
    ImageView localImageView = this.CQX;
    s.s(localImageView, "certificateTorchLightBlock1");
    ((View)localImageView).scrollTo(0, 0);
    localImageView = this.CQY;
    s.s(localImageView, "certificateTorchLightBlock2");
    ((View)localImageView).scrollTo(0, 0);
    localImageView = this.CRg;
    s.s(localImageView, "certificateTorchLight");
    ((View)localImageView).scrollTo(0, 0);
    localImageView = this.CRf;
    s.s(localImageView, "certificateTorch");
    ((View)localImageView).scrollTo(0, 0);
    AppMethodBeat.o(360999);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(361167);
    s.u(parama, "showMode");
    switch (g.b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(361167);
      return;
      parama = this.CQN;
      s.s(parama, "certificateUpdateContent");
      a((View)parama, true, (kotlin.g.a.a)new c(this));
      this.lKz.close();
      AppMethodBeat.o(361167);
      return;
      this.CQN.setVisibility(0);
      this.CRh.setVisibility(8);
      parama = this.CQb;
      if (parama != null) {
        parama.setText((CharSequence)this.mJe.getContext().getString(p.h.Cpx));
      }
      this.lKz.start();
    }
  }
  
  public void c(com.tencent.mm.plugin.finder.live.olympic.certificate.data.a parama)
  {
    int j = 8;
    AppMethodBeat.i(361148);
    s.u(parama, "t");
    this.CQQ.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.mJe.getContext(), (CharSequence)parama.CPj.name));
    this.CQR.setText((CharSequence)this.mJe.getContext().getString(p.h.Cpi, new Object[] { Long.valueOf(parama.CPj.CPl) }));
    Object localObject1 = (CharSequence)parama.CPj.oyP;
    label152:
    Object localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)parama.CPj.CPn;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label625;
        }
        i = 1;
        if (i == 0) {
          break label631;
        }
      }
      this.CQU.setVisibility(8);
      if (parama.CPj.CPm.size() <= 0) {
        break label788;
      }
      this.CQS.setText((CharSequence)kotlin.a.p.a((Iterable)kotlin.a.p.t((Iterable)parama.CPj.CPm), (CharSequence)" · ", null, null, 0, null, null, 62));
      localObject1 = this.CQS;
      if (!parama.CPj.CPs) {
        break label781;
      }
      localObject2 = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
      if (!com.tencent.mm.plugin.finder.live.olympic.util.a.eot()) {
        break label781;
      }
      i = 0;
      label251:
      ((GradientTextView)localObject1).setVisibility(i);
      label258:
      this.CQT.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cpz, new Object[] { Long.valueOf(parama.CPj.CPo) }));
      this.CQT.eoe();
      localObject1 = this.CRd;
      if (!parama.CPj.CPp) {
        break label800;
      }
    }
    label781:
    label788:
    label800:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      localObject1 = this.CQT;
      i = j;
      if (parama.CPj.CPr)
      {
        i = j;
        if (parama.CPj.CPo > 0L)
        {
          i = j;
          if (parama.CPj.CPq) {
            i = 0;
          }
        }
      }
      ((GradientTextView)localObject1).setVisibility(i);
      parama = this.CQQ;
      i = Color.parseColor("#996431");
      j = Color.parseColor("#D1A05B");
      int k = Color.parseColor("#C28E4A");
      float f1 = parama.getPaint().getTextSize();
      float f2 = parama.getText().length();
      float f3 = parama.getPaint().getTextSize();
      localObject1 = Shader.TileMode.CLAMP;
      localObject1 = new LinearGradient(0.0F, 0.0F, f1 * f2, f3, new int[] { i, j, k }, new float[] { 0.0F, 0.6666667F, 1.0F }, (Shader.TileMode)localObject1);
      parama.getPaint().setShader((Shader)localObject1);
      this.CQR.eoc();
      parama = this.CQW;
      localObject1 = new LinearGradient(0.0F, 0.0F, parama.getPaint().getTextSize() * parama.getText().length(), parama.getPaint().getTextSize(), parama.fhI, parama.fhI, Shader.TileMode.CLAMP);
      parama.getPaint().setShader((Shader)localObject1);
      parama.invalidate();
      this.CQS.eod();
      this.CQT.eoe();
      AppMethodBeat.o(361148);
      return;
      i = 0;
      break;
      label625:
      i = 0;
      break label152;
      label631:
      this.CQU.setVisibility(0);
      localObject2 = parama.CPj.oyP;
      if (localObject2 != null)
      {
        if (((String)localObject2).length() <= 10) {
          break label766;
        }
        localObject1 = this.CQW;
        localObject2 = ((String)localObject2).substring(0, 10);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((GradientTextView)localObject1).setText((CharSequence)s.X((String)localObject2, "..."));
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject2 = new com.tencent.mm.plugin.finder.loader.b(parama.CPj.CPn);
        ImageView localImageView = this.CQV;
        s.s(localImageView, "certificateAcceptHead");
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        break;
        label766:
        this.CQW.setText((CharSequence)localObject2);
      }
      i = 8;
      break label251;
      this.CQS.setVisibility(8);
      break label258;
    }
  }
  
  public final void ck(float paramFloat)
  {
    float f2 = 16.0F;
    AppMethodBeat.i(361227);
    this.pxl += paramFloat;
    float f1;
    if (this.pxl > 16.0F)
    {
      this.pxl -= paramFloat;
      paramFloat = 16.0F;
      f1 = 3.0F * paramFloat - this.CRc;
      if (f1 <= 0.0F) {
        break label216;
      }
      f1 = Math.min(f1, CRm);
      label71:
      this.CQZ.setTranslationY(f1);
      if (paramFloat <= 0.0F) {
        break label228;
      }
      f1 = Math.min(paramFloat, CRk);
      label93:
      this.CRg.scrollTo(-(int)f1, 0);
      this.CRf.scrollTo(-(int)f1, 0);
      if (paramFloat <= 16.0F) {
        break label240;
      }
      f1 = f2;
      label125:
      this.CRe.setRotationY(f1);
      paramFloat *= 5.0F;
      if (paramFloat <= 0.0F) {
        break label260;
      }
    }
    label260:
    for (paramFloat = Math.min(paramFloat, CRl);; paramFloat = Math.max(paramFloat, -CRl))
    {
      this.CQX.scrollTo(0, (int)paramFloat);
      this.CQY.scrollTo(0, (int)paramFloat);
      AppMethodBeat.o(361227);
      return;
      if (this.pxl < -16.0F)
      {
        this.pxl -= paramFloat;
        paramFloat = -16.0F;
        break;
      }
      paramFloat = this.pxl;
      break;
      label216:
      f1 = Math.max(f1, -CRm);
      break label71;
      label228:
      f1 = Math.max(paramFloat, -CRk);
      break label93;
      label240:
      if (paramFloat < -16.0F)
      {
        f1 = -16.0F;
        break label125;
      }
      f1 = paramFloat;
      break label125;
    }
  }
  
  public void enQ()
  {
    AppMethodBeat.i(361182);
    int i = OT(40);
    i = getScreenWidth() - i * 2;
    int k = (int)(i / 0.6385282F);
    int j;
    if ((aw.ato()) || (aw.jkP()))
    {
      int m = OT(295);
      j = OT(462);
      if (i > m) {
        i = m;
      }
    }
    for (;;)
    {
      Log.i("BaseOlympicCertificateW", s.X("adjustLayout scaleDensity: ", Float.valueOf(enP())));
      Object localObject = this.CRe.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(361182);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = i;
      ((ViewGroup.MarginLayoutParams)localObject).height = j;
      localObject = this.CRf.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(361182);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(i / 1.685714F * enP()));
      ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(((ViewGroup.MarginLayoutParams)localObject).width / 0.75F));
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (-(int)(((ViewGroup.MarginLayoutParams)localObject).height / 3.609375F));
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (-(int)(((ViewGroup.MarginLayoutParams)localObject).width / 3.5F));
      localObject = this.CRg.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(361182);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(i / 1.378505F));
      ((ViewGroup.MarginLayoutParams)localObject).height = ((ViewGroup.MarginLayoutParams)localObject).width;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (-((ViewGroup.MarginLayoutParams)localObject).width / 2);
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (-((ViewGroup.MarginLayoutParams)localObject).width / 2);
      localObject = this.CRh.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(361182);
        throw ((Throwable)localObject);
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(OT(48) * enP()));
      ViewGroup.LayoutParams localLayoutParams = this.CRd.getLayoutParams();
      localObject = Float.valueOf(enP());
      if (((Number)localObject).floatValue() > 0.8F)
      {
        j = 1;
        if (j == 0) {
          break label477;
        }
        label432:
        if (localObject != null) {
          break label483;
        }
      }
      label477:
      label483:
      for (float f = 0.8F;; f = ((Float)localObject).floatValue())
      {
        localLayoutParams.width = ((int)(f * (i / 2.304688F)));
        localLayoutParams.height = localLayoutParams.width;
        AppMethodBeat.o(361182);
        return;
        j = 0;
        break;
        localObject = null;
        break label432;
      }
      j = k;
    }
  }
  
  public final ImageView enW()
  {
    return this.CRf;
  }
  
  public final ImageView enX()
  {
    return this.CRg;
  }
  
  public final void enY()
  {
    AppMethodBeat.i(361214);
    this.CQO.clearFocus();
    Object localObject = this.mJe.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(361214);
      throw ((Throwable)localObject);
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.CQO.getWindowToken(), 0);
    AppMethodBeat.o(361214);
  }
  
  public final void eoa()
  {
    AppMethodBeat.i(361242);
    Log.i("BaseOlympicCertificateW", "registerGyroscopeSensor");
    View localView = this.CQZ;
    localView.setVisibility(0);
    localView.setAlpha(0.0F);
    localView.animate().alpha(0.4F).setDuration(300L).start();
    this.CRb.enN();
    AppMethodBeat.o(361242);
  }
  
  public final void eob()
  {
    AppMethodBeat.i(361246);
    this.CQZ.setVisibility(8);
    Log.i("BaseOlympicCertificateW", "unRegisterGyroscopeSensor");
    this.CRb.enO();
    enZ();
    AppMethodBeat.o(361246);
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(361191);
    Object localObject = this.CRe;
    s.s(localObject, "certificateLayoutPositive");
    localObject = (View)localObject;
    AppMethodBeat.o(361191);
    return localObject;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(361203);
    if (paramView == null) {}
    for (paramView = null;; paramView = Integer.valueOf(paramView.getId()))
    {
      i = p.e.BQk;
      if (paramView != null) {
        break;
      }
      AppMethodBeat.o(361203);
      return;
    }
    if (paramView.intValue() == i)
    {
      paramView = this.CQb;
      if (paramView == null) {
        break label118;
      }
      paramView = paramView.getText();
      if ((paramView == null) || (paramView.equals(this.mJe.getContext().getString(p.h.Cpw)) != true)) {
        break label118;
      }
    }
    label118:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.CPS.by(this.CQO.getEditableText().toString(), false);
      }
      AppMethodBeat.o(361203);
      return;
    }
  }
  
  public final void qQ(boolean paramBoolean)
  {
    AppMethodBeat.i(361116);
    Button localButton = this.CQb;
    if (localButton != null)
    {
      if (!paramBoolean)
      {
        localButton.setEnabled(false);
        localButton.setTextColor(this.mJe.getContext().getResources().getColor(p.b.BW_0_Alpha_0_3));
        AppMethodBeat.o(361116);
        return;
      }
      localButton.setEnabled(true);
      localButton.setTextColor(-1);
    }
    AppMethodBeat.o(361116);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(361155);
    this.CQP.setText((CharSequence)"");
    this.CQO.setText((CharSequence)"");
    qQ(false);
    this.CQN.setVisibility(8);
    this.CRh.setVisibility(0);
    enY();
    AppMethodBeat.o(361155);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(361108);
    super.unMount();
    eob();
    this.lKz.close();
    AppMethodBeat.o(361108);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.g
 * JD-Core Version:    0.7.0.1
 */