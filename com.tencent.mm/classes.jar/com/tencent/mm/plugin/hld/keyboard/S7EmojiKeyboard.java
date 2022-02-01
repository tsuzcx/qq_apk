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
import com.tencent.mm.plugin.hld.emoji.j;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.protocal.protobuf.fmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiSubTypeSelectListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "closeKeyboardRl", "Landroid/widget/RelativeLayout;", "getCloseKeyboardRl", "()Landroid/widget/RelativeLayout;", "closeKeyboardRl$delegate", "Lkotlin/Lazy;", "currentEmojiType", "", "deleteBt", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getDeleteBt", "()Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "deleteBt$delegate", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "emojiContentContainerRv$delegate", "emojiKeyContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getEmojiKeyContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "emojiKeyContainer$delegate", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "emojiTypeRl", "getEmojiTypeRl", "emojiTypeRl$delegate", "hideRect", "Landroid/graphics/Rect;", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper;", "kaoemojiContentContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "getKaoemojiContentContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "kaoemojiContentContainerRv$delegate", "kaoemojiLine", "Landroid/widget/ImageView;", "getKaoemojiLine", "()Landroid/widget/ImageView;", "kaoemojiLine$delegate", "kaoemojiSubTypeContainerRv", "getKaoemojiSubTypeContainerRv", "kaoemojiSubTypeContainerRv$delegate", "kaoemojiTypeRl", "getKaoemojiTypeRl", "kaoemojiTypeRl$delegate", "keyboardSwLl", "Landroid/widget/LinearLayout;", "getKeyboardSwLl", "()Landroid/widget/LinearLayout;", "keyboardSwLl$delegate", "pageSelectedListener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "sendBt", "getSendBt", "sendBt$delegate", "sendBtVisible", "", "getContentSize", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onClick", "", "v", "Landroid/view/View;", "onCreate", "onEmojiSubTypeClick", "position", "itemView", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouch", "event", "Landroid/view/MotionEvent;", "setTabSelected", "groupIndex", "updateEnterKey", "actionStr", "actionMode", "updateView", "Companion", "plugin-hld_release"})
public final class S7EmojiKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.hld.emoji.b
{
  public static final a Dzo;
  private final d DvX;
  private String Dwu;
  private final f Dwv;
  private final f Dww;
  private final i Dwx;
  private final i.a Dwy;
  private final f Dzd;
  private final f Dze;
  private final f Dzf;
  private final f Dzg;
  private final f Dzh;
  private final f Dzi;
  private final f Dzj;
  private final f Dzk;
  private final f Dzl;
  private final f Dzm;
  private boolean Dzn;
  private final Rect jLp;
  
  static
  {
    AppMethodBeat.i(216073);
    Dzo = new a((byte)0);
    AppMethodBeat.o(216073);
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
    AppMethodBeat.i(216071);
    paramContext = com.tencent.mm.plugin.hld.f.g.DHh;
    this.Dwu = com.tencent.mm.plugin.hld.f.g.eGz();
    this.Dwx = new i();
    this.Dwv = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.Dzd = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.Dww = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Dze = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Dzf = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Dzg = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.Dzh = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.Dzi = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.Dzj = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dzk = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.Dzl = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.Dzm = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.jLp = new Rect();
    this.Dzn = true;
    this.Dwy = ((i.a)new n(this));
    this.DvX = ((d)new o(this));
    AppMethodBeat.o(216071);
  }
  
  private final int getContentSize()
  {
    AppMethodBeat.i(216066);
    String str = this.Dwu;
    switch (str.hashCode())
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(216066);
        return 0;
      } while (!str.equals("emoji"));
      i = getEmojiContentContainerRv().getEmojiList().size();
      AppMethodBeat.o(216066);
      return i;
    } while (!str.equals("kaoemoji"));
    int i = getKaoemojiContentContainerRv().getKaoemojiList().size();
    AppMethodBeat.o(216066);
    return i;
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(216061);
    String str = this.Dwu;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216061);
      return;
      if (str.equals("emoji"))
      {
        getEmojiTypeRl().setBackground(com.tencent.mm.ci.a.m(getContext(), a.e.ime_s8_emoji_type_bg_selected));
        getKaoemojiTypeRl().setBackground(null);
        getEmojiKeyContainer().setVisibility(0);
        getEmojiContentContainerRv().setVisibility(0);
        getKaoemojiContentContainerRv().setVisibility(8);
        getEmojiSubTypeContainerRv().setVisibility(0);
        getKaoemojiSubTypeContainerRv().setVisibility(8);
        this.Dwx.a((RecyclerView)getEmojiContentContainerRv());
        getKaoemojiLine().setVisibility(8);
        AppMethodBeat.o(216061);
        return;
        if (str.equals("kaoemoji"))
        {
          getEmojiTypeRl().setBackground(null);
          getKaoemojiTypeRl().setBackground(com.tencent.mm.ci.a.m(getContext(), a.e.ime_s8_emoji_type_bg_selected));
          getEmojiKeyContainer().setVisibility(8);
          getEmojiContentContainerRv().setVisibility(8);
          getKaoemojiContentContainerRv().setVisibility(0);
          getEmojiSubTypeContainerRv().setVisibility(8);
          getKaoemojiSubTypeContainerRv().setVisibility(0);
          this.Dwx.a((RecyclerView)getKaoemojiContentContainerRv());
          getKaoemojiLine().setVisibility(0);
        }
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(216046);
    super.b(paramc);
    updateView();
    AppMethodBeat.o(216046);
  }
  
  public final void eO(String paramString, int paramInt)
  {
    AppMethodBeat.i(216054);
    p.k(paramString, "actionStr");
    boolean bool = this.Dzn;
    ImeKeyButton localImeKeyButton = getSendBt();
    if (Util.isEqual(paramString, getContext().getString(a.j.key_action_send)))
    {
      this.Dzn = true;
      localImeKeyButton.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    while (bool != this.Dzn)
    {
      paramString = getEmojiContentContainerRv().getAdapter();
      if (paramString == null) {
        break;
      }
      paramString.notifyDataSetChanged();
      AppMethodBeat.o(216054);
      return;
      localImeKeyButton.setClickable(true);
      localImeKeyButton.setEnabled(true);
      ImeKeyButton.a(localImeKeyButton);
      paramInt = a.c.ime_emoji_key_send_text_style;
      localImeKeyButton.getButtonTextView().setTextColor(localImeKeyButton.getResources().getColorStateList(paramInt));
      continue;
      localImeKeyButton.setClickable(false);
      localImeKeyButton.setEnabled(false);
      localImeKeyButton.UO(a.c.S2_text_invalid_color);
      continue;
      this.Dzn = false;
      localImeKeyButton.setVisibility(8);
    }
    AppMethodBeat.o(216054);
  }
  
  public final RelativeLayout getCloseKeyboardRl()
  {
    AppMethodBeat.i(216036);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzj.getValue();
    AppMethodBeat.o(216036);
    return localRelativeLayout;
  }
  
  public final ImeKeyButton getDeleteBt()
  {
    AppMethodBeat.i(216039);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)this.Dzl.getValue();
    AppMethodBeat.o(216039);
    return localImeKeyButton;
  }
  
  public final ImeEmojiContentScrollView getEmojiContentContainerRv()
  {
    AppMethodBeat.i(216030);
    ImeEmojiContentScrollView localImeEmojiContentScrollView = (ImeEmojiContentScrollView)this.Dww.getValue();
    AppMethodBeat.o(216030);
    return localImeEmojiContentScrollView;
  }
  
  public final ConstraintLayout getEmojiKeyContainer()
  {
    AppMethodBeat.i(216032);
    ConstraintLayout localConstraintLayout = (ConstraintLayout)this.Dzf.getValue();
    AppMethodBeat.o(216032);
    return localConstraintLayout;
  }
  
  public final ImeEmojiSubTypeScrollView getEmojiSubTypeContainerRv()
  {
    AppMethodBeat.i(216028);
    ImeEmojiSubTypeScrollView localImeEmojiSubTypeScrollView = (ImeEmojiSubTypeScrollView)this.Dwv.getValue();
    AppMethodBeat.o(216028);
    return localImeEmojiSubTypeScrollView;
  }
  
  public final RelativeLayout getEmojiTypeRl()
  {
    AppMethodBeat.i(216033);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzg.getValue();
    AppMethodBeat.o(216033);
    return localRelativeLayout;
  }
  
  public final ImeKaoEmojiContentScrollView getKaoemojiContentContainerRv()
  {
    AppMethodBeat.i(216031);
    ImeKaoEmojiContentScrollView localImeKaoEmojiContentScrollView = (ImeKaoEmojiContentScrollView)this.Dze.getValue();
    AppMethodBeat.o(216031);
    return localImeKaoEmojiContentScrollView;
  }
  
  public final ImageView getKaoemojiLine()
  {
    AppMethodBeat.i(216038);
    ImageView localImageView = (ImageView)this.Dzk.getValue();
    AppMethodBeat.o(216038);
    return localImageView;
  }
  
  public final ImeEmojiSubTypeScrollView getKaoemojiSubTypeContainerRv()
  {
    AppMethodBeat.i(216029);
    ImeEmojiSubTypeScrollView localImeEmojiSubTypeScrollView = (ImeEmojiSubTypeScrollView)this.Dzd.getValue();
    AppMethodBeat.o(216029);
    return localImeEmojiSubTypeScrollView;
  }
  
  public final RelativeLayout getKaoemojiTypeRl()
  {
    AppMethodBeat.i(216034);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzh.getValue();
    AppMethodBeat.o(216034);
    return localRelativeLayout;
  }
  
  public final LinearLayout getKeyboardSwLl()
  {
    AppMethodBeat.i(216035);
    LinearLayout localLinearLayout = (LinearLayout)this.Dzi.getValue();
    AppMethodBeat.o(216035);
    return localLinearLayout;
  }
  
  public final c getKeyboardType()
  {
    return c.Dyr;
  }
  
  public final ImeKeyButton getSendBt()
  {
    AppMethodBeat.i(216041);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)this.Dzm.getValue();
    AppMethodBeat.o(216041);
    return localImeKeyButton;
  }
  
  public final void j(int paramInt, View paramView)
  {
    AppMethodBeat.i(216050);
    p.k(paramView, "itemView");
    setTabSelected(paramInt);
    paramView = com.tencent.mm.plugin.hld.f.g.DHh;
    paramView = getRootView();
    p.j(paramView, "rootView");
    paramView = paramView.getContext();
    p.j(paramView, "rootView.context");
    if (com.tencent.mm.plugin.hld.f.g.K(paramView, this.Dwu, "recent").MGI.isEmpty()) {}
    for (int i = paramInt - 1;; i = paramInt)
    {
      paramView = this.Dwu;
      switch (paramView.hashCode())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(216050);
        return;
        if (paramView.equals("emoji"))
        {
          paramView = getEmojiContentContainerRv();
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aFh(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramView.scrollToPosition(((Integer)locala.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramView = com.tencent.mm.plugin.hld.model.k.DDb;
          paramView = com.tencent.mm.plugin.hld.f.g.DHh;
          com.tencent.mm.plugin.hld.model.k.n(4, com.tencent.mm.plugin.hld.f.g.UH(paramInt), 1);
          AppMethodBeat.o(216050);
          return;
          if (paramView.equals("kaoemoji"))
          {
            paramView = getKaoemojiContentContainerRv();
            locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aFh(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)locala.sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
            paramView = com.tencent.mm.plugin.hld.model.k.DDb;
            paramView = com.tencent.mm.plugin.hld.f.g.DHh;
            com.tencent.mm.plugin.hld.model.k.n(5, com.tencent.mm.plugin.hld.f.g.UI(paramInt), 2);
          }
        }
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216053);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      localObject = Integer.valueOf(paramView.getId());
      i = a.f.emoji_type_rl;
      if (localObject != null) {
        break label119;
      }
      label59:
      i = a.f.kaoemoji_type_rl;
      if (localObject != null) {
        break label184;
      }
      label67:
      i = a.f.s8_key_send;
      if (localObject != null) {
        break label249;
      }
      label75:
      i = a.f.keyboard_container_ll;
      if (localObject != null) {
        break label289;
      }
      label83:
      i = a.f.right_container_ll;
      if (localObject != null) {
        break label349;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216053);
      return;
      localObject = null;
      break;
      label119:
      if (((Integer)localObject).intValue() != i) {
        break label59;
      }
      if (!Util.isEqual(this.Dwu, "emoji"))
      {
        this.Dwu = "emoji";
        paramView = com.tencent.mm.plugin.hld.f.g.DHh;
        com.tencent.mm.plugin.hld.f.g.aLH(this.Dwu);
        updateView();
        paramView = com.tencent.mm.plugin.hld.model.k.DDb;
        paramView = com.tencent.mm.plugin.hld.f.g.DHh;
        com.tencent.mm.plugin.hld.model.k.n(2, com.tencent.mm.plugin.hld.f.g.aLG("emoji"), 1);
        continue;
        label184:
        if (((Integer)localObject).intValue() != i) {
          break label67;
        }
        if (!Util.isEqual(this.Dwu, "kaoemoji"))
        {
          this.Dwu = "kaoemoji";
          paramView = com.tencent.mm.plugin.hld.f.g.DHh;
          com.tencent.mm.plugin.hld.f.g.aLH(this.Dwu);
          updateView();
          paramView = com.tencent.mm.plugin.hld.model.k.DDb;
          paramView = com.tencent.mm.plugin.hld.f.g.DHh;
          com.tencent.mm.plugin.hld.model.k.n(3, com.tencent.mm.plugin.hld.f.g.aLG("kaoemoji"), 2);
          continue;
          label249:
          if (((Integer)localObject).intValue() != i) {
            break label75;
          }
          if ((paramView instanceof ImeKeyRelativeLayout))
          {
            localObject = getMKeyboardActionListener();
            if (localObject != null)
            {
              ((com.tencent.mm.plugin.hld.a.c)localObject).Up(((ImeKeyRelativeLayout)paramView).getFunctionCode());
              continue;
              label289:
              if (((Integer)localObject).intValue() != i) {
                break label83;
              }
              paramView = com.tencent.mm.plugin.hld.model.g.DCm;
              if (com.tencent.mm.plugin.hld.model.g.eEm() != c.Dyr.ordinal())
              {
                paramView.a(c.Dyr);
                paramView = com.tencent.mm.plugin.hld.model.k.DDb;
                com.tencent.mm.plugin.hld.model.k.UC(0);
              }
              else
              {
                paramView.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
                paramView = com.tencent.mm.plugin.hld.model.k.DDb;
                com.tencent.mm.plugin.hld.model.k.UC(1);
                continue;
                label349:
                if (((Integer)localObject).intValue() == i)
                {
                  paramView = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
                  if (paramView != null)
                  {
                    paramView = paramView.eCD();
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
    AppMethodBeat.i(216045);
    super.onCreate();
    getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((com.tencent.mm.plugin.hld.emoji.b)this);
    getKaoemojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((com.tencent.mm.plugin.hld.emoji.b)this);
    getEmojiContentContainerRv().setRecentSelectedListener(this.DvX);
    getKaoemojiContentContainerRv().setRecentSelectedListener(this.DvX);
    this.Dwx.Dwl = this.Dwy;
    com.tencent.mm.plugin.hld.view.g localg = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getEmojiTypeRl(), (View.OnClickListener)this);
    localg = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getKaoemojiTypeRl(), (View.OnClickListener)this);
    localg = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getKeyboardSwLl(), (View.OnClickListener)this);
    localg = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getCloseKeyboardRl(), (View.OnClickListener)this);
    localg = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getSendBt(), (View.OnClickListener)this);
    getDeleteBt().setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(216045);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(216048);
    super.onReset();
    getEmojiContentContainerRv();
    getKaoemojiContentContainerRv();
    AppMethodBeat.o(216048);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216063);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("WxIme.S7EmojiKeyboard", "onSizeChanged " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramInt4);
    post((Runnable)new m(this));
    AppMethodBeat.o(216063);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(216056);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)paramView)) {
        ImeKeyboard.a(this, (ImeKeyRelativeLayout)paramView, paramMotionEvent);
      }
    }
    AppMethodBeat.o(216056);
    return false;
  }
  
  public final void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(216058);
    Log.i("WxIme.S7EmojiKeyboard", "setTabSelected: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject1 = getContext();
    p.j(localObject1, "context");
    localObject1 = com.tencent.mm.plugin.hld.f.g.be((Context)localObject1, this.Dwu);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = this.Dwu;
      switch (((String)localObject1).hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216058);
      return;
      if (((String)localObject1).equals("emoji"))
      {
        localObject1 = getEmojiSubTypeContainerRv().getAdapter();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeAdapter");
          AppMethodBeat.o(216058);
          throw ((Throwable)localObject1);
          if (!((String)localObject1).equals("kaoemoji")) {
            continue;
          }
          localObject1 = getKaoemojiSubTypeContainerRv().getAdapter();
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeAdapter");
            AppMethodBeat.o(216058);
            throw ((Throwable)localObject1);
          }
        }
        else
        {
          localObject1 = (j)localObject1;
          localObject2 = getContext();
          p.j(localObject2, "context");
          ((j)localObject1).au((Context)localObject2, paramInt);
          localObject1 = getEmojiSubTypeContainerRv();
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
          ((ImeEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(216058);
          return;
        }
        localObject1 = (j)localObject1;
        Object localObject2 = getContext();
        p.j(localObject2, "context");
        ((j)localObject1).au((Context)localObject2, paramInt);
        localObject1 = getKaoemojiSubTypeContainerRv();
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((ImeEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ImeKeyButton>
  {
    c(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImeEmojiContentScrollView>
  {
    d(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ConstraintLayout>
  {
    e(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImeEmojiSubTypeScrollView>
  {
    f(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ImeKaoEmojiContentScrollView>
  {
    h(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<ImeEmojiSubTypeScrollView>
  {
    j(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    k(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    l(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(S7EmojiKeyboard paramS7EmojiKeyboard) {}
    
    public final void run()
    {
      AppMethodBeat.i(209778);
      S7EmojiKeyboard.a(this.Dzp).setEmpty();
      S7EmojiKeyboard.a(this.Dzp).union(this.Dzp.getDeleteBt().getLeft(), this.Dzp.getDeleteBt().getTop(), this.Dzp.getDeleteBt().getRight(), this.Dzp.getDeleteBt().getBottom());
      S7EmojiKeyboard.a(this.Dzp).union(this.Dzp.getSendBt().getLeft(), this.Dzp.getSendBt().getTop(), this.Dzp.getSendBt().getRight(), this.Dzp.getSendBt().getBottom());
      if (p.h(S7EmojiKeyboard.b(this.Dzp), "emoji"))
      {
        Object localObject2 = this.Dzp.getEmojiContentContainerRv();
        Object localObject1 = S7EmojiKeyboard.a(this.Dzp);
        p.k(localObject1, "rect");
        Object localObject3 = com.tencent.mm.plugin.hld.f.g.DHh;
        localObject3 = com.tencent.mm.plugin.hld.f.g.aLG("emoji");
        Object localObject4 = (List)((ImeEmojiContentScrollView)localObject2).DvW;
        int i = 0;
        localObject4 = ((List)localObject4).iterator();
        if (((Iterator)localObject4).hasNext()) {
          if (!p.h(((com.tencent.mm.plugin.hld.emoji.k)((Iterator)localObject4).next()).typeName, localObject3)) {}
        }
        for (;;)
        {
          localObject3 = ((ImeEmojiContentScrollView)localObject2).cK(i);
          if ((!(localObject3 instanceof e)) || (!(((e)localObject3).Dwa.getLayoutManager() instanceof EmojiLayoutManager))) {
            break label390;
          }
          localObject3 = ((e)localObject3).Dwa.getLayoutManager();
          if (localObject3 != null) {
            break label294;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.EmojiLayoutManager");
          AppMethodBeat.o(209778);
          throw ((Throwable)localObject1);
          i += 1;
          break;
          i = -1;
        }
        label294:
        localObject3 = (EmojiLayoutManager)localObject3;
        localObject2 = ((ImeEmojiContentScrollView)localObject2).getContext();
        p.j(localObject2, "context");
        p.k(localObject1, "rect");
        p.k(localObject2, "context");
        ((EmojiLayoutManager)localObject3).jLp.set((Rect)localObject1);
        EmojiLayoutManager.a((EmojiLayoutManager)localObject3);
        Log.i("WxIme.EmojiLayoutManager", "updateHideArea ".concat(String.valueOf(localObject1)));
        if (((EmojiLayoutManager)localObject3).maxHeight == 0)
        {
          ((EmojiLayoutManager)localObject3).maxHeight = ((Context)localObject2).getResources().getDimensionPixelSize(a.d.Edge_A);
          ((EmojiLayoutManager)localObject3).DvR = ((Context)localObject2).getResources().getDimensionPixelSize(a.d.ime_emoji_top_bottom_margin);
        }
      }
      label390:
      AppMethodBeat.o(209778);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard$pageSelectedListener$1", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-hld_release"})
  public static final class n
    implements i.a
  {
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(210709);
      if ((paramInt < 0) || (paramInt >= S7EmojiKeyboard.c(this.Dzp)))
      {
        AppMethodBeat.o(210709);
        return;
      }
      Object localObject = com.tencent.mm.plugin.hld.f.g.DHh;
      localObject = this.Dzp.getRootView();
      p.j(localObject, "rootView");
      localObject = ((View)localObject).getContext();
      p.j(localObject, "rootView.context");
      if (com.tencent.mm.plugin.hld.f.g.K((Context)localObject, S7EmojiKeyboard.b(this.Dzp), "recent").MGI.isEmpty()) {}
      for (int i = paramInt + 1;; i = paramInt)
      {
        this.Dzp.setTabSelected(i);
        localObject = S7EmojiKeyboard.b(this.Dzp);
        switch (((String)localObject).hashCode())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(210709);
          return;
          if (((String)localObject).equals("emoji"))
          {
            localObject = com.tencent.mm.plugin.hld.model.k.DDb;
            localObject = com.tencent.mm.plugin.hld.f.g.DHh;
            com.tencent.mm.plugin.hld.model.k.n(8, com.tencent.mm.plugin.hld.f.g.UH(paramInt), 1);
            AppMethodBeat.o(210709);
            return;
            if (((String)localObject).equals("kaoemoji"))
            {
              localObject = com.tencent.mm.plugin.hld.model.k.DDb;
              localObject = com.tencent.mm.plugin.hld.f.g.DHh;
              com.tencent.mm.plugin.hld.model.k.n(8, com.tencent.mm.plugin.hld.f.g.UI(paramInt), 2);
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/keyboard/S7EmojiKeyboard$recentSelectedListener$1", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-hld_release"})
  public static final class o
    implements d
  {
    public final void aLt(String paramString)
    {
      AppMethodBeat.i(212680);
      p.k(paramString, "typeName");
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(212680);
            return;
          } while (!paramString.equals("emoji"));
          paramString = this.Dzp.getEmojiSubTypeContainerRv().getAdapter();
          if (paramString == null) {
            break;
          }
          paramString.cL(0);
          AppMethodBeat.o(212680);
          return;
        } while (!paramString.equals("kaoemoji"));
        paramString = this.Dzp.getKaoemojiSubTypeContainerRv().getAdapter();
      } while (paramString == null);
      paramString.cL(0);
      AppMethodBeat.o(212680);
      return;
      AppMethodBeat.o(212680);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<ImeKeyButton>
  {
    p(S7EmojiKeyboard paramS7EmojiKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S7EmojiKeyboard
 * JD-Core Version:    0.7.0.1
 */