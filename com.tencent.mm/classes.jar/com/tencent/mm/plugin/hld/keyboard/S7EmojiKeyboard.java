package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.emoji.EmojiLayoutManager;
import com.tencent.mm.plugin.hld.emoji.ImeEmojiContentScrollView;
import com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeScrollView;
import com.tencent.mm.plugin.hld.emoji.ImeKaoEmojiContentScrollView;
import com.tencent.mm.plugin.hld.emoji.e;
import com.tencent.mm.plugin.hld.emoji.i;
import com.tencent.mm.plugin.hld.emoji.i.a;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.protocal.protobuf.gjn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiSubTypeSelectListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "closeKeyboardRl", "Landroid/widget/RelativeLayout;", "getCloseKeyboardRl", "()Landroid/widget/RelativeLayout;", "closeKeyboardRl$delegate", "Lkotlin/Lazy;", "currentEmojiType", "", "deleteBt", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getDeleteBt", "()Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "deleteBt$delegate", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "emojiContentContainerRv$delegate", "emojiKeyContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getEmojiKeyContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "emojiKeyContainer$delegate", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "emojiTypeRl", "getEmojiTypeRl", "emojiTypeRl$delegate", "hideRect", "Landroid/graphics/Rect;", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper;", "kaoemojiContentContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "getKaoemojiContentContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "kaoemojiContentContainerRv$delegate", "kaoemojiLine", "Landroid/widget/ImageView;", "getKaoemojiLine", "()Landroid/widget/ImageView;", "kaoemojiLine$delegate", "kaoemojiSubTypeContainerRv", "getKaoemojiSubTypeContainerRv", "kaoemojiSubTypeContainerRv$delegate", "kaoemojiTypeRl", "getKaoemojiTypeRl", "kaoemojiTypeRl$delegate", "keyboardSwLl", "Landroid/widget/LinearLayout;", "getKeyboardSwLl", "()Landroid/widget/LinearLayout;", "keyboardSwLl$delegate", "pageSelectedListener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "sendBt", "getSendBt", "sendBt$delegate", "sendBtVisible", "", "getContentSize", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onClick", "", "v", "Landroid/view/View;", "onCreate", "onEmojiSubTypeClick", "position", "itemView", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouch", "event", "Landroid/view/MotionEvent;", "setTabSelected", "groupIndex", "updateEnterKey", "actionStr", "actionMode", "updateView", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S7EmojiKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.hld.emoji.b
{
  public static final S7EmojiKeyboard.a Jsf;
  private String JpB;
  private final kotlin.j JpC;
  private final kotlin.j JpD;
  private final i JpE;
  private final i.a JpF;
  private final d Jpe;
  private final kotlin.j Jsg;
  private final kotlin.j Jsh;
  private final kotlin.j Jsi;
  private final kotlin.j Jsj;
  private final kotlin.j Jsk;
  private final kotlin.j Jsl;
  private final kotlin.j Jsm;
  private final kotlin.j Jsn;
  private final kotlin.j Jso;
  private final kotlin.j Jsp;
  private boolean Jsq;
  private final Rect mkA;
  
  static
  {
    AppMethodBeat.i(313242);
    Jsf = new S7EmojiKeyboard.a((byte)0);
    AppMethodBeat.o(313242);
  }
  
  public S7EmojiKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S7EmojiKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S7EmojiKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(313212);
    paramContext = com.tencent.mm.plugin.hld.f.g.Jyo;
    this.JpB = com.tencent.mm.plugin.hld.f.g.fOn();
    this.JpE = new i();
    this.JpC = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Jsg = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.JpD = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Jsh = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Jsi = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Jsj = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Jsk = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.Jsl = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.Jsm = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jsn = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.Jso = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Jsp = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.mkA = new Rect();
    this.Jsq = true;
    this.JpF = ((i.a)new m(this));
    this.Jpe = ((d)new n(this));
    AppMethodBeat.o(313212);
  }
  
  private static final void a(S7EmojiKeyboard paramS7EmojiKeyboard)
  {
    AppMethodBeat.i(313229);
    s.u(paramS7EmojiKeyboard, "this$0");
    paramS7EmojiKeyboard.mkA.setEmpty();
    paramS7EmojiKeyboard.mkA.union(paramS7EmojiKeyboard.getDeleteBt().getLeft(), paramS7EmojiKeyboard.getDeleteBt().getTop(), paramS7EmojiKeyboard.getDeleteBt().getRight(), paramS7EmojiKeyboard.getDeleteBt().getBottom());
    paramS7EmojiKeyboard.mkA.union(paramS7EmojiKeyboard.getSendBt().getLeft(), paramS7EmojiKeyboard.getSendBt().getTop(), paramS7EmojiKeyboard.getSendBt().getRight(), paramS7EmojiKeyboard.getSendBt().getBottom());
    if (s.p(paramS7EmojiKeyboard.JpB, "emoji"))
    {
      Object localObject1 = paramS7EmojiKeyboard.getEmojiContentContainerRv();
      paramS7EmojiKeyboard = paramS7EmojiKeyboard.mkA;
      s.u(paramS7EmojiKeyboard, "rect");
      Object localObject2 = com.tencent.mm.plugin.hld.f.g.Jyo;
      localObject2 = com.tencent.mm.plugin.hld.f.g.aIz("emoji");
      Object localObject3 = (List)((ImeEmojiContentScrollView)localObject1).Jpd;
      int i = 0;
      localObject3 = ((List)localObject3).iterator();
      if (((Iterator)localObject3).hasNext()) {
        if (!s.p(((com.tencent.mm.plugin.hld.emoji.k)((Iterator)localObject3).next()).typeName, localObject2)) {}
      }
      for (;;)
      {
        localObject2 = ((ImeEmojiContentScrollView)localObject1).fU(i);
        if ((!(localObject2 instanceof e)) || (!(((e)localObject2).Jph.getLayoutManager() instanceof EmojiLayoutManager))) {
          break label347;
        }
        localObject2 = ((e)localObject2).Jph.getLayoutManager();
        if (localObject2 != null) {
          break label256;
        }
        paramS7EmojiKeyboard = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.EmojiLayoutManager");
        AppMethodBeat.o(313229);
        throw paramS7EmojiKeyboard;
        i += 1;
        break;
        i = -1;
      }
      label256:
      localObject2 = (EmojiLayoutManager)localObject2;
      localObject1 = ((ImeEmojiContentScrollView)localObject1).getContext();
      s.s(localObject1, "context");
      s.u(paramS7EmojiKeyboard, "rect");
      s.u(localObject1, "context");
      ((EmojiLayoutManager)localObject2).mkA.set(paramS7EmojiKeyboard);
      EmojiLayoutManager.a((EmojiLayoutManager)localObject2);
      Log.i("WxIme.EmojiLayoutManager", s.X("updateHideArea ", paramS7EmojiKeyboard));
      if (((EmojiLayoutManager)localObject2).maxHeight == 0)
      {
        ((EmojiLayoutManager)localObject2).maxHeight = ((Context)localObject1).getResources().getDimensionPixelSize(a.d.Edge_A);
        ((EmojiLayoutManager)localObject2).JoY = ((Context)localObject1).getResources().getDimensionPixelSize(a.d.ime_emoji_top_bottom_margin);
      }
    }
    label347:
    AppMethodBeat.o(313229);
  }
  
  private final int getContentSize()
  {
    AppMethodBeat.i(313221);
    String str = this.JpB;
    int i;
    if (s.p(str, "emoji"))
    {
      i = getEmojiContentContainerRv().getEmojiList().size();
      AppMethodBeat.o(313221);
      return i;
    }
    if (s.p(str, "kaoemoji"))
    {
      i = getKaoemojiContentContainerRv().getKaoemojiList().size();
      AppMethodBeat.o(313221);
      return i;
    }
    AppMethodBeat.o(313221);
    return 0;
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(313218);
    String str = this.JpB;
    if (s.p(str, "emoji"))
    {
      getEmojiTypeRl().setBackground(com.tencent.mm.cd.a.m(getContext(), a.e.ime_s8_emoji_type_bg_selected));
      getKaoemojiTypeRl().setBackground(null);
      getEmojiKeyContainer().setVisibility(0);
      getEmojiContentContainerRv().setVisibility(0);
      getKaoemojiContentContainerRv().setVisibility(8);
      getEmojiSubTypeContainerRv().setVisibility(0);
      getKaoemojiSubTypeContainerRv().setVisibility(8);
      this.JpE.a((RecyclerView)getEmojiContentContainerRv());
      getKaoemojiLine().setVisibility(8);
      AppMethodBeat.o(313218);
      return;
    }
    if (s.p(str, "kaoemoji"))
    {
      getEmojiTypeRl().setBackground(null);
      getKaoemojiTypeRl().setBackground(com.tencent.mm.cd.a.m(getContext(), a.e.ime_s8_emoji_type_bg_selected));
      getEmojiKeyContainer().setVisibility(8);
      getEmojiContentContainerRv().setVisibility(8);
      getKaoemojiContentContainerRv().setVisibility(0);
      getEmojiSubTypeContainerRv().setVisibility(8);
      getKaoemojiSubTypeContainerRv().setVisibility(0);
      this.JpE.a((RecyclerView)getKaoemojiContentContainerRv());
      getKaoemojiLine().setVisibility(0);
    }
    AppMethodBeat.o(313218);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313292);
    super.b(paramc);
    updateView();
    AppMethodBeat.o(313292);
  }
  
  public final void fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(313331);
    s.u(paramString, "actionStr");
    boolean bool = this.Jsq;
    ImeKeyButton localImeKeyButton = getSendBt();
    if (Util.isEqual(paramString, getContext().getString(a.j.key_action_send)))
    {
      this.Jsq = true;
      localImeKeyButton.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (bool != this.Jsq)
      {
        paramString = getEmojiContentContainerRv().getAdapter();
        if (paramString != null) {
          paramString.bZE.notifyChanged();
        }
      }
      AppMethodBeat.o(313331);
      return;
      localImeKeyButton.setClickable(true);
      localImeKeyButton.setEnabled(true);
      ImeKeyButton.a(localImeKeyButton);
      paramInt = a.c.ime_emoji_key_send_text_style;
      localImeKeyButton.getButtonTextView().setTextColor(localImeKeyButton.getResources().getColorStateList(paramInt));
      continue;
      localImeKeyButton.setClickable(false);
      localImeKeyButton.setEnabled(false);
      localImeKeyButton.YM(a.c.S2_text_invalid_color);
      continue;
      this.Jsq = false;
      localImeKeyButton.setVisibility(8);
    }
  }
  
  public final RelativeLayout getCloseKeyboardRl()
  {
    AppMethodBeat.i(313276);
    Object localObject = this.Jsm.getValue();
    s.s(localObject, "<get-closeKeyboardRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313276);
    return localObject;
  }
  
  public final ImeKeyButton getDeleteBt()
  {
    AppMethodBeat.i(313280);
    Object localObject = this.Jso.getValue();
    s.s(localObject, "<get-deleteBt>(...)");
    localObject = (ImeKeyButton)localObject;
    AppMethodBeat.o(313280);
    return localObject;
  }
  
  public final ImeEmojiContentScrollView getEmojiContentContainerRv()
  {
    AppMethodBeat.i(313262);
    Object localObject = this.JpD.getValue();
    s.s(localObject, "<get-emojiContentContainerRv>(...)");
    localObject = (ImeEmojiContentScrollView)localObject;
    AppMethodBeat.o(313262);
    return localObject;
  }
  
  public final ConstraintLayout getEmojiKeyContainer()
  {
    AppMethodBeat.i(313268);
    Object localObject = this.Jsi.getValue();
    s.s(localObject, "<get-emojiKeyContainer>(...)");
    localObject = (ConstraintLayout)localObject;
    AppMethodBeat.o(313268);
    return localObject;
  }
  
  public final ImeEmojiSubTypeScrollView getEmojiSubTypeContainerRv()
  {
    AppMethodBeat.i(313250);
    Object localObject = this.JpC.getValue();
    s.s(localObject, "<get-emojiSubTypeContainerRv>(...)");
    localObject = (ImeEmojiSubTypeScrollView)localObject;
    AppMethodBeat.o(313250);
    return localObject;
  }
  
  public final RelativeLayout getEmojiTypeRl()
  {
    AppMethodBeat.i(313271);
    Object localObject = this.Jsj.getValue();
    s.s(localObject, "<get-emojiTypeRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313271);
    return localObject;
  }
  
  public final ImeKaoEmojiContentScrollView getKaoemojiContentContainerRv()
  {
    AppMethodBeat.i(313265);
    Object localObject = this.Jsh.getValue();
    s.s(localObject, "<get-kaoemojiContentContainerRv>(...)");
    localObject = (ImeKaoEmojiContentScrollView)localObject;
    AppMethodBeat.o(313265);
    return localObject;
  }
  
  public final ImageView getKaoemojiLine()
  {
    AppMethodBeat.i(313279);
    Object localObject = this.Jsn.getValue();
    s.s(localObject, "<get-kaoemojiLine>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(313279);
    return localObject;
  }
  
  public final ImeEmojiSubTypeScrollView getKaoemojiSubTypeContainerRv()
  {
    AppMethodBeat.i(313257);
    Object localObject = this.Jsg.getValue();
    s.s(localObject, "<get-kaoemojiSubTypeContainerRv>(...)");
    localObject = (ImeEmojiSubTypeScrollView)localObject;
    AppMethodBeat.o(313257);
    return localObject;
  }
  
  public final RelativeLayout getKaoemojiTypeRl()
  {
    AppMethodBeat.i(313272);
    Object localObject = this.Jsk.getValue();
    s.s(localObject, "<get-kaoemojiTypeRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313272);
    return localObject;
  }
  
  public final LinearLayout getKeyboardSwLl()
  {
    AppMethodBeat.i(313274);
    Object localObject = this.Jsl.getValue();
    s.s(localObject, "<get-keyboardSwLl>(...)");
    localObject = (LinearLayout)localObject;
    AppMethodBeat.o(313274);
    return localObject;
  }
  
  public final c getKeyboardType()
  {
    return c.Jrv;
  }
  
  public final ImeKeyButton getSendBt()
  {
    AppMethodBeat.i(313284);
    Object localObject = this.Jsp.getValue();
    s.s(localObject, "<get-sendBt>(...)");
    localObject = (ImeKeyButton)localObject;
    AppMethodBeat.o(313284);
    return localObject;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(313326);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      localObject = null;
      i = a.f.emoji_type_rl;
      if (localObject != null) {
        break label119;
      }
      label53:
      i = a.f.kaoemoji_type_rl;
      if (localObject != null) {
        break label184;
      }
      label61:
      i = a.f.s8_key_send;
      if (localObject != null) {
        break label249;
      }
      label69:
      i = a.f.keyboard_container_ll;
      if (localObject != null) {
        break label289;
      }
      label77:
      i = a.f.right_container_ll;
      if (localObject != null) {
        break label349;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(313326);
      return;
      localObject = Integer.valueOf(paramView.getId());
      break;
      label119:
      if (((Integer)localObject).intValue() != i) {
        break label53;
      }
      if (!Util.isEqual(this.JpB, "emoji"))
      {
        this.JpB = "emoji";
        paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
        com.tencent.mm.plugin.hld.f.g.aIA(this.JpB);
        updateView();
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
        com.tencent.mm.plugin.hld.model.k.r(2, com.tencent.mm.plugin.hld.f.g.aIz("emoji"), 1);
        continue;
        label184:
        if (((Integer)localObject).intValue() != i) {
          break label61;
        }
        if (!Util.isEqual(this.JpB, "kaoemoji"))
        {
          this.JpB = "kaoemoji";
          paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
          com.tencent.mm.plugin.hld.f.g.aIA(this.JpB);
          updateView();
          paramView = com.tencent.mm.plugin.hld.model.k.JvH;
          paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
          com.tencent.mm.plugin.hld.model.k.r(3, com.tencent.mm.plugin.hld.f.g.aIz("kaoemoji"), 2);
          continue;
          label249:
          if (((Integer)localObject).intValue() != i) {
            break label69;
          }
          if ((paramView instanceof ImeKeyRelativeLayout))
          {
            localObject = getMKeyboardActionListener();
            if (localObject != null)
            {
              ((com.tencent.mm.plugin.hld.a.c)localObject).Yl(((ImeKeyRelativeLayout)paramView).getFunctionCode());
              continue;
              label289:
              if (((Integer)localObject).intValue() != i) {
                break label77;
              }
              paramView = com.tencent.mm.plugin.hld.model.g.JuL;
              if (com.tencent.mm.plugin.hld.model.g.fMo() != c.Jrv.ordinal())
              {
                paramView.a(c.Jrv);
                paramView = com.tencent.mm.plugin.hld.model.k.JvH;
                com.tencent.mm.plugin.hld.model.k.Yz(0);
              }
              else
              {
                paramView.Yu(com.tencent.mm.plugin.hld.model.g.fMq());
                paramView = com.tencent.mm.plugin.hld.model.k.JvH;
                com.tencent.mm.plugin.hld.model.k.Yz(1);
                continue;
                label349:
                if (((Integer)localObject).intValue() == i)
                {
                  paramView = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
                  if (paramView != null)
                  {
                    paramView = paramView.fKG();
                    if (paramView != null) {
                      paramView.requestHideSelf(0);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(313290);
    super.onCreate();
    getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((com.tencent.mm.plugin.hld.emoji.b)this);
    getKaoemojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((com.tencent.mm.plugin.hld.emoji.b)this);
    getEmojiContentContainerRv().setRecentSelectedListener(this.Jpe);
    getKaoemojiContentContainerRv().setRecentSelectedListener(this.Jpe);
    this.JpE.Jpr = this.JpF;
    f.JzR.a((View)getEmojiTypeRl(), (View.OnClickListener)this);
    f.JzR.a((View)getKaoemojiTypeRl(), (View.OnClickListener)this);
    f.JzR.a((View)getKeyboardSwLl(), (View.OnClickListener)this);
    f.JzR.a((View)getCloseKeyboardRl(), (View.OnClickListener)this);
    f.JzR.a((View)getSendBt(), (View.OnClickListener)this);
    getDeleteBt().setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(313290);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(313305);
    super.onReset();
    getEmojiContentContainerRv();
    getKaoemojiContentContainerRv();
    AppMethodBeat.o(313305);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(313348);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("WxIme.S7EmojiKeyboard", "onSizeChanged " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramInt4);
    post(new S7EmojiKeyboard..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(313348);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313336);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      l locall = l.JyV;
      if (l.e((ImeKeyRelativeLayout)paramView)) {
        ImeKeyboard.a((ImeKeyboard)this, (ImeKeyRelativeLayout)paramView, paramMotionEvent);
      }
    }
    AppMethodBeat.o(313336);
    return false;
  }
  
  public final void q(int paramInt, View paramView)
  {
    AppMethodBeat.i(313316);
    s.u(paramView, "itemView");
    setTabSelected(paramInt);
    paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
    paramView = getRootView().getContext();
    s.s(paramView, "rootView.context");
    if (com.tencent.mm.plugin.hld.f.g.K(paramView, this.JpB, "recent").Trs.isEmpty()) {}
    for (int i = paramInt - 1;; i = paramInt)
    {
      paramView = this.JpB;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (s.p(paramView, "emoji"))
      {
        paramView = getEmojiContentContainerRv();
        locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
        com.tencent.mm.plugin.hld.model.k.r(4, com.tencent.mm.plugin.hld.f.g.YF(paramInt), 1);
        AppMethodBeat.o(313316);
        return;
      }
      if (s.p(paramView, "kaoemoji"))
      {
        paramView = getKaoemojiContentContainerRv();
        locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        paramView = com.tencent.mm.plugin.hld.f.g.Jyo;
        com.tencent.mm.plugin.hld.model.k.r(5, com.tencent.mm.plugin.hld.f.g.YG(paramInt), 2);
      }
      AppMethodBeat.o(313316);
      return;
    }
  }
  
  public final void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(313345);
    Log.i("WxIme.S7EmojiKeyboard", "setTabSelected: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = com.tencent.mm.plugin.hld.f.g.Jyo;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject1 = com.tencent.mm.plugin.hld.f.g.bg((Context)localObject1, this.JpB);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = this.JpB;
      Object localObject2;
      if (s.p(localObject1, "emoji"))
      {
        localObject1 = getEmojiSubTypeContainerRv().getAdapter();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeAdapter");
          AppMethodBeat.o(313345);
          throw ((Throwable)localObject1);
        }
        localObject1 = (com.tencent.mm.plugin.hld.emoji.j)localObject1;
        localObject2 = getContext();
        s.s(localObject2, "context");
        ((com.tencent.mm.plugin.hld.emoji.j)localObject1).aH((Context)localObject2, paramInt);
        localObject1 = getEmojiSubTypeContainerRv();
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((ImeEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(313345);
        return;
      }
      if (s.p(localObject1, "kaoemoji"))
      {
        localObject1 = getKaoemojiSubTypeContainerRv().getAdapter();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeAdapter");
          AppMethodBeat.o(313345);
          throw ((Throwable)localObject1);
        }
        localObject1 = (com.tencent.mm.plugin.hld.emoji.j)localObject1;
        localObject2 = getContext();
        s.s(localObject2, "context");
        ((com.tencent.mm.plugin.hld.emoji.j)localObject1).aH((Context)localObject2, paramInt);
        localObject1 = getKaoemojiSubTypeContainerRv();
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((ImeEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
    }
    AppMethodBeat.o(313345);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImeKeyButton>
  {
    c(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImeEmojiContentScrollView>
  {
    d(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ConstraintLayout>
  {
    e(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImeEmojiSubTypeScrollView>
  {
    f(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ImeKaoEmojiContentScrollView>
  {
    h(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    i(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ImeEmojiSubTypeScrollView>
  {
    j(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    k(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    l(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard$pageSelectedListener$1", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements i.a
  {
    m(S7EmojiKeyboard paramS7EmojiKeyboard) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(312951);
      if ((paramInt < 0) || (paramInt >= S7EmojiKeyboard.b(this.Jsr)))
      {
        AppMethodBeat.o(312951);
        return;
      }
      Object localObject = com.tencent.mm.plugin.hld.f.g.Jyo;
      localObject = this.Jsr.getRootView().getContext();
      s.s(localObject, "rootView.context");
      if (com.tencent.mm.plugin.hld.f.g.K((Context)localObject, S7EmojiKeyboard.c(this.Jsr), "recent").Trs.isEmpty()) {}
      for (int i = paramInt + 1;; i = paramInt)
      {
        this.Jsr.setTabSelected(i);
        localObject = S7EmojiKeyboard.c(this.Jsr);
        if (s.p(localObject, "emoji"))
        {
          localObject = com.tencent.mm.plugin.hld.model.k.JvH;
          localObject = com.tencent.mm.plugin.hld.f.g.Jyo;
          com.tencent.mm.plugin.hld.model.k.r(8, com.tencent.mm.plugin.hld.f.g.YF(paramInt), 1);
          AppMethodBeat.o(312951);
          return;
        }
        if (s.p(localObject, "kaoemoji"))
        {
          localObject = com.tencent.mm.plugin.hld.model.k.JvH;
          localObject = com.tencent.mm.plugin.hld.f.g.Jyo;
          com.tencent.mm.plugin.hld.model.k.r(8, com.tencent.mm.plugin.hld.f.g.YG(paramInt), 2);
        }
        AppMethodBeat.o(312951);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard$recentSelectedListener$1", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements d
  {
    n(S7EmojiKeyboard paramS7EmojiKeyboard) {}
    
    public final void aIk(String paramString)
    {
      AppMethodBeat.i(312953);
      s.u(paramString, "typeName");
      if (s.p(paramString, "emoji"))
      {
        paramString = this.Jsr.getEmojiSubTypeContainerRv().getAdapter();
        if (paramString != null)
        {
          paramString.fV(0);
          AppMethodBeat.o(312953);
        }
      }
      else if (s.p(paramString, "kaoemoji"))
      {
        paramString = this.Jsr.getKaoemojiSubTypeContainerRv().getAdapter();
        if (paramString != null) {
          paramString.fV(0);
        }
      }
      AppMethodBeat.o(312953);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ImeKeyButton>
  {
    o(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S7EmojiKeyboard
 * JD-Core Version:    0.7.0.1
 */