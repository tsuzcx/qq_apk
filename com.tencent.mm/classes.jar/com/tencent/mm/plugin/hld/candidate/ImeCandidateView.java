package com.tencent.mm.plugin.hld.candidate;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeEditText;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.threadpool.i;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.PendingInput;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "accountContainerRl", "Landroid/widget/RelativeLayout;", "getAccountContainerRl", "()Landroid/widget/RelativeLayout;", "accountContainerRl$delegate", "Lkotlin/Lazy;", "associationContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getAssociationContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "associationContainerRv$delegate", "candidateList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "candidateListfetching", "", "clipBoardContainerRv", "getClipBoardContainerRv", "clipBoardContainerRv$delegate", "clipBoardTv", "Landroid/widget/TextView;", "getClipBoardTv", "()Landroid/widget/TextView;", "clipBoardTv$delegate", "closeClipboardIv", "Landroid/widget/ImageView;", "getCloseClipboardIv", "()Landroid/widget/ImageView;", "closeClipboardIv$delegate", "closeIv", "getCloseIv", "closeIv$delegate", "hasClipboardContent", "hasMoreCandidate", "hasStrikeContent", "ifEditTextEmpty", "Ljava/lang/Boolean;", "logoIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLogoIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "logoIv$delegate", "mIKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "nameIv", "getNameIv", "nameIv$delegate", "normalContainerRl", "getNormalContainerRl", "normalContainerRl$delegate", "packUpContainerRl", "getPackUpContainerRl", "packUpContainerRl$delegate", "packUpLl", "getPackUpLl", "packUpLl$delegate", "rightContainerLl", "getRightContainerLl", "rightContainerLl$delegate", "shapeIv", "getShapeIv", "shapeIv$delegate", "strikeContainerRl", "getStrikeContainerRl", "strikeContainerRl$delegate", "strikeContainerSv", "Landroid/widget/HorizontalScrollView;", "getStrikeContainerSv", "()Landroid/widget/HorizontalScrollView;", "strikeContainerSv$delegate", "strikeLogoContainerRl", "getStrikeLogoContainerRl", "strikeLogoContainerRl$delegate", "strikeTv", "getStrikeTv", "strikeTv$delegate", "ifShieldCandidateView", "init", "", "listener", "onClick", "v", "Landroid/view/View;", "text", "", "id", "", "order", "pressTime", "", "onLongClick", "onResume", "refreshCandidateView", "fromPendingInput", "refreshEditText", "reset", "scrollBy", "distance", "showCandidateView", "showClipBoard", "showClipboardContent", "updateCandidateByStatus", "updateCandidateList", "addList", "type", "newList", "hasMore", "updateEnglishStrikeView", "pendingInputText", "", "lastPendingInputContent", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "cursorIndex", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "updateStrikeView", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeCandidateView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener, a, b, d.a
{
  public static final ImeCandidateView.a JnN;
  private com.tencent.mm.plugin.hld.a.c JnO;
  private final j JnP;
  private final j JnQ;
  private final j JnR;
  private final j JnS;
  private final j JnT;
  private final j JnU;
  private final j JnV;
  private final j JnW;
  private final j JnX;
  private final j JnY;
  private final j JnZ;
  private final ArrayList<Candidate> Jns;
  private boolean Jnw;
  private boolean Jnx;
  private final j Joa;
  private final j Job;
  private final j Joc;
  private final j Jod;
  private final j Joe;
  private final j Jof;
  private boolean Jog;
  private boolean Joh;
  private Boolean Joi;
  
  static
  {
    AppMethodBeat.i(313231);
    JnN = new ImeCandidateView.a((byte)0);
    AppMethodBeat.o(313231);
  }
  
  public ImeCandidateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeCandidateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeCandidateView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(312933);
    this.JnP = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.JnQ = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.JnR = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.JnS = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.JnT = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.JnU = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.JnV = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.JnW = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.JnX = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.JnY = kotlin.k.cm((kotlin.g.a.a)new r(this));
    this.JnZ = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.Joa = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Job = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Joc = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Jod = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Joe = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Jof = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jns = new ArrayList();
    af.mU(getContext()).inflate(a.h.ime_candidate_container, (ViewGroup)this, true);
    setOrientation(1);
    com.tencent.mm.plugin.hld.view.f.JzR.a((View)getRightContainerLl(), (View.OnClickListener)this);
    com.tencent.mm.plugin.hld.view.f.JzR.a((View)getClipBoardTv(), (View.OnClickListener)this);
    com.tencent.mm.plugin.hld.view.f.JzR.a((View)getPackUpLl(), (View.OnClickListener)this);
    com.tencent.mm.plugin.hld.view.f.JzR.a((View)getStrikeContainerRl(), (View.OnClickListener)this);
    com.tencent.mm.plugin.hld.view.f.JzR.a((View)getAccountContainerRl(), (View.OnClickListener)this);
    getStrikeTv().addTextChangedListener((TextWatcher)new TextWatcher()
    {
      private static final void h(ImeCandidateView paramAnonymousImeCandidateView)
      {
        AppMethodBeat.i(312835);
        s.u(paramAnonymousImeCandidateView, "this$0");
        ImeCandidateView.c(paramAnonymousImeCandidateView).scrollTo(ImeCandidateView.c(paramAnonymousImeCandidateView).getWidth(), 0);
        AppMethodBeat.o(312835);
      }
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(312846);
        ImeCandidateView.c(this.Joj).post(new ImeCandidateView.1..ExternalSyntheticLambda0(this.Joj));
        AppMethodBeat.o(312846);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    getAssociationContainerRv().setAdapter((RecyclerView.a)new c(this.Jns, (d.a)this));
    paramContext = new WxLinearLayoutManager(getContext());
    paramContext.setOrientation(0);
    getAssociationContainerRv().setLayoutManager((RecyclerView.LayoutManager)paramContext);
    getAssociationContainerRv().a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(312843);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(312843);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(312837);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        if (ImeCandidateView.d(this.Joj).isEmpty())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(312837);
          return;
        }
        if ((ImeCandidateView.e(this.Joj)) && (!ImeCandidateView.f(this.Joj)) && (ImeCandidateView.d(this.Joj).size() - paramContext.Jw() <= 5))
        {
          ImeCandidateView.g(this.Joj);
          paramAnonymousRecyclerView = n.JvW;
          n.fMQ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(312837);
      }
    });
    paramContext = l.JyV;
    if (l.fKH())
    {
      getNameIv().setVisibility(0);
      getLogoIv().setVisibility(8);
      AppMethodBeat.o(312933);
      return;
    }
    getNameIv().setVisibility(8);
    getLogoIv().setVisibility(0);
    getLogoIv().setOnLongClickListener((View.OnLongClickListener)this);
    AppMethodBeat.o(312933);
  }
  
  private static final void a(ImeCandidateView paramImeCandidateView, int paramInt)
  {
    AppMethodBeat.i(313161);
    s.u(paramImeCandidateView, "this$0");
    paramImeCandidateView.getAssociationContainerRv().scrollBy(paramInt, 0);
    AppMethodBeat.o(313161);
  }
  
  private static final void a(ImeCandidateView paramImeCandidateView, boolean paramBoolean)
  {
    AppMethodBeat.i(313194);
    s.u(paramImeCandidateView, "this$0");
    Object localObject = com.tencent.mm.plugin.hld.model.g.JuL;
    int j = com.tencent.mm.plugin.hld.model.g.fMl();
    switch (j)
    {
    }
    for (;;)
    {
      if (fKO())
      {
        paramImeCandidateView.getAssociationContainerRv().setVisibility(8);
        if (j != 4)
        {
          paramImeCandidateView.getCloseIv().setVisibility(0);
          paramImeCandidateView.getShapeIv().setVisibility(8);
        }
      }
      AppMethodBeat.o(313194);
      return;
      paramImeCandidateView.getNormalContainerRl().setVisibility(0);
      localObject = l.JyV;
      if (l.fKH())
      {
        paramImeCandidateView.getAccountContainerRl().setVisibility(8);
        paramImeCandidateView.getAssociationContainerRv().setVisibility(0);
      }
      for (;;)
      {
        paramImeCandidateView.getPackUpContainerRl().setVisibility(8);
        paramImeCandidateView.getRightContainerLl().setVisibility(0);
        paramImeCandidateView.getCloseIv().setVisibility(0);
        paramImeCandidateView.getCloseClipboardIv().setVisibility(8);
        paramImeCandidateView.getShapeIv().setVisibility(8);
        break;
        localObject = l.JyV;
        if (!l.bGa())
        {
          localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
          if (localObject == null) {
            break label256;
          }
          localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
          if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).fKx() != true)) {
            break label256;
          }
        }
        label256:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label261;
          }
          paramImeCandidateView.getAccountContainerRl().setVisibility(8);
          paramImeCandidateView.getAssociationContainerRv().setVisibility(0);
          break;
        }
        label261:
        paramImeCandidateView.getAccountContainerRl().setVisibility(0);
        paramImeCandidateView.getAssociationContainerRv().setVisibility(8);
      }
      localObject = com.tencent.mm.plugin.hld.model.g.JuL;
      if ((com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jru)) && (paramBoolean))
      {
        paramImeCandidateView.getNormalContainerRl().setVisibility(8);
        paramImeCandidateView.getAssociationContainerRv().setVisibility(8);
        paramImeCandidateView.getPackUpContainerRl().setVisibility(0);
        paramImeCandidateView.getRightContainerLl().setVisibility(8);
      }
      else
      {
        paramImeCandidateView.getNormalContainerRl().setVisibility(0);
        paramImeCandidateView.getAssociationContainerRv().setVisibility(0);
        paramImeCandidateView.getAccountContainerRl().setVisibility(8);
        paramImeCandidateView.getPackUpContainerRl().setVisibility(8);
        paramImeCandidateView.getRightContainerLl().setVisibility(0);
        paramImeCandidateView.getCloseIv().setVisibility(0);
        paramImeCandidateView.getCloseClipboardIv().setVisibility(8);
        paramImeCandidateView.getShapeIv().setVisibility(8);
        continue;
        localObject = com.tencent.mm.plugin.hld.model.g.JuL;
        if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jru))
        {
          paramImeCandidateView.getNormalContainerRl().setVisibility(8);
          paramImeCandidateView.getAssociationContainerRv().setVisibility(8);
          paramImeCandidateView.getPackUpContainerRl().setVisibility(0);
          paramImeCandidateView.getRightContainerLl().setVisibility(8);
        }
        else
        {
          paramImeCandidateView.getNormalContainerRl().setVisibility(0);
          paramImeCandidateView.getAssociationContainerRv().setVisibility(0);
          paramImeCandidateView.getAccountContainerRl().setVisibility(8);
          paramImeCandidateView.getPackUpContainerRl().setVisibility(8);
          paramImeCandidateView.getRightContainerLl().setVisibility(0);
          paramImeCandidateView.getCloseIv().setVisibility(8);
          paramImeCandidateView.getCloseClipboardIv().setVisibility(8);
          paramImeCandidateView.getShapeIv().setVisibility(0);
          continue;
          paramImeCandidateView.getNormalContainerRl().setVisibility(0);
          paramImeCandidateView.getAssociationContainerRv().setVisibility(8);
          paramImeCandidateView.getAccountContainerRl().setVisibility(8);
          paramImeCandidateView.getPackUpContainerRl().setVisibility(8);
          paramImeCandidateView.getRightContainerLl().setVisibility(0);
          paramImeCandidateView.getCloseIv().setVisibility(8);
          paramImeCandidateView.getCloseClipboardIv().setVisibility(0);
          paramImeCandidateView.getShapeIv().setVisibility(8);
        }
      }
    }
  }
  
  private static final void b(ImeCandidateView paramImeCandidateView)
  {
    AppMethodBeat.i(313174);
    s.u(paramImeCandidateView, "this$0");
    Object localObject = l.JyV;
    boolean bool = l.fOH();
    Log.i("WxIme.WxImeCandidateView", "refreshEditText " + paramImeCandidateView.Joi + ' ' + bool);
    if (!s.p(paramImeCandidateView.Joi, Boolean.valueOf(bool)))
    {
      localObject = com.tencent.mm.plugin.hld.model.g.JuL;
      com.tencent.mm.plugin.hld.model.g.ax(paramImeCandidateView.Jog, paramImeCandidateView.Joh);
      paramImeCandidateView.wO(false);
    }
    paramImeCandidateView.Joi = Boolean.valueOf(bool);
    AppMethodBeat.o(313174);
  }
  
  private final void d(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(313124);
    e locale = e.Jon;
    if (e.fKQ())
    {
      getStrikeTv().setText((CharSequence)getContext().getString(a.j.wxime_clipboard_desc));
      paramCharSequence = e.Jon;
      if (!e.fKQ()) {
        break label106;
      }
      getStrikeTv().setVisibility(0);
      getStrikeLogoContainerRl().setVisibility(8);
      this.Jog = false;
    }
    for (;;)
    {
      paramCharSequence = com.tencent.mm.plugin.hld.model.g.JuL;
      com.tencent.mm.plugin.hld.model.g.ax(this.Jog, this.Joh);
      wO(paramBoolean);
      AppMethodBeat.o(313124);
      return;
      getStrikeTv().setText(paramCharSequence);
      break;
      label106:
      if (Util.isNullOrNil(getStrikeTv().getText().toString()))
      {
        getStrikeTv().setVisibility(8);
        getStrikeLogoContainerRl().setVisibility(0);
        this.Jog = false;
      }
      else
      {
        getStrikeTv().setVisibility(0);
        getStrikeLogoContainerRl().setVisibility(8);
        this.Jog = true;
      }
    }
  }
  
  private static boolean fKO()
  {
    AppMethodBeat.i(313151);
    Object localObject = l.JyV;
    if (l.fKH())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.JuL;
      switch (com.tencent.mm.plugin.hld.model.g.fMl())
      {
      case 2: 
      default: 
        AppMethodBeat.o(313151);
        return false;
      }
      AppMethodBeat.o(313151);
      return true;
    }
    localObject = com.tencent.mm.plugin.hld.model.g.JuL;
    if (com.tencent.mm.plugin.hld.model.g.fMp())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.JuL;
      if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrs))
      {
        localObject = com.tencent.mm.plugin.hld.model.g.JuL;
        if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrr)) {}
      }
      else
      {
        AppMethodBeat.o(313151);
        return true;
      }
    }
    AppMethodBeat.o(313151);
    return false;
  }
  
  private final RelativeLayout getAccountContainerRl()
  {
    AppMethodBeat.i(313103);
    Object localObject = this.Jof.getValue();
    s.s(localObject, "<get-accountContainerRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313103);
    return localObject;
  }
  
  private final RecyclerView getAssociationContainerRv()
  {
    AppMethodBeat.i(313096);
    Object localObject = this.Joe.getValue();
    s.s(localObject, "<get-associationContainerRv>(...)");
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(313096);
    return localObject;
  }
  
  private final RelativeLayout getClipBoardContainerRv()
  {
    AppMethodBeat.i(313075);
    Object localObject = this.Joc.getValue();
    s.s(localObject, "<get-clipBoardContainerRv>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313075);
    return localObject;
  }
  
  private final TextView getClipBoardTv()
  {
    AppMethodBeat.i(313086);
    Object localObject = this.Jod.getValue();
    s.s(localObject, "<get-clipBoardTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(313086);
    return localObject;
  }
  
  private final ImageView getCloseClipboardIv()
  {
    AppMethodBeat.i(313048);
    Object localObject = this.Joa.getValue();
    s.s(localObject, "<get-closeClipboardIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(313048);
    return localObject;
  }
  
  private final ImageView getCloseIv()
  {
    AppMethodBeat.i(313061);
    Object localObject = this.Job.getValue();
    s.s(localObject, "<get-closeIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(313061);
    return localObject;
  }
  
  private final WeImageView getLogoIv()
  {
    AppMethodBeat.i(312974);
    Object localObject = this.JnS.getValue();
    s.s(localObject, "<get-logoIv>(...)");
    localObject = (WeImageView)localObject;
    AppMethodBeat.o(312974);
    return localObject;
  }
  
  private final TextView getNameIv()
  {
    AppMethodBeat.i(312983);
    Object localObject = this.JnT.getValue();
    s.s(localObject, "<get-nameIv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312983);
    return localObject;
  }
  
  private final RelativeLayout getNormalContainerRl()
  {
    AppMethodBeat.i(312991);
    Object localObject = this.JnU.getValue();
    s.s(localObject, "<get-normalContainerRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312991);
    return localObject;
  }
  
  private final RelativeLayout getPackUpContainerRl()
  {
    AppMethodBeat.i(312997);
    Object localObject = this.JnV.getValue();
    s.s(localObject, "<get-packUpContainerRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312997);
    return localObject;
  }
  
  private final RelativeLayout getPackUpLl()
  {
    AppMethodBeat.i(313022);
    Object localObject = this.JnX.getValue();
    s.s(localObject, "<get-packUpLl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313022);
    return localObject;
  }
  
  private final RelativeLayout getRightContainerLl()
  {
    AppMethodBeat.i(313009);
    Object localObject = this.JnW.getValue();
    s.s(localObject, "<get-rightContainerLl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313009);
    return localObject;
  }
  
  private final ImageView getShapeIv()
  {
    AppMethodBeat.i(313034);
    Object localObject = this.JnZ.getValue();
    s.s(localObject, "<get-shapeIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(313034);
    return localObject;
  }
  
  private final RelativeLayout getStrikeContainerRl()
  {
    AppMethodBeat.i(312955);
    Object localObject = this.JnQ.getValue();
    s.s(localObject, "<get-strikeContainerRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312955);
    return localObject;
  }
  
  private final HorizontalScrollView getStrikeContainerSv()
  {
    AppMethodBeat.i(312944);
    Object localObject = this.JnP.getValue();
    s.s(localObject, "<get-strikeContainerSv>(...)");
    localObject = (HorizontalScrollView)localObject;
    AppMethodBeat.o(312944);
    return localObject;
  }
  
  private final RelativeLayout getStrikeLogoContainerRl()
  {
    AppMethodBeat.i(312964);
    Object localObject = this.JnR.getValue();
    s.s(localObject, "<get-strikeLogoContainerRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312964);
    return localObject;
  }
  
  private final void wM(boolean paramBoolean)
  {
    AppMethodBeat.i(313113);
    Object localObject = n.JvW;
    if (n.fMH())
    {
      localObject = e.Jon;
      if (e.fKQ()) {
        wN(true);
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.hld.model.g.JuL;
      com.tencent.mm.plugin.hld.model.g.ax(this.Jog, this.Joh);
      wO(paramBoolean);
      AppMethodBeat.o(313113);
      return;
      wN(false);
    }
  }
  
  private final void wN(boolean paramBoolean)
  {
    AppMethodBeat.i(313121);
    if (paramBoolean)
    {
      getAssociationContainerRv().setVisibility(8);
      getClipBoardContainerRv().setVisibility(0);
      TextView localTextView = getClipBoardTv();
      e locale = e.Jon;
      localTextView.setText(e.fKS());
      getClipBoardTv().setHorizontallyScrolling(true);
      getClipBoardTv().setMovementMethod(ScrollingMovementMethod.getInstance());
      getClipBoardTv().scrollTo(0, 0);
      this.Joh = true;
      AppMethodBeat.o(313121);
      return;
    }
    if (fKO()) {
      getAssociationContainerRv().setVisibility(8);
    }
    for (;;)
    {
      getClipBoardContainerRv().setVisibility(8);
      this.Joh = false;
      AppMethodBeat.o(313121);
      return;
      getAssociationContainerRv().setVisibility(0);
    }
  }
  
  private void wO(boolean paramBoolean)
  {
    AppMethodBeat.i(313130);
    com.tencent.threadpool.h.ahAA.bk(new ImeCandidateView..ExternalSyntheticLambda2(this, paramBoolean));
    AppMethodBeat.o(313130);
  }
  
  public final void Yn(int paramInt)
  {
    AppMethodBeat.i(313317);
    getAccountContainerRl().post(new ImeCandidateView..ExternalSyntheticLambda1(this, paramInt));
    AppMethodBeat.o(313317);
  }
  
  public final void a(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313273);
    this.JnO = paramc;
    paramc = n.JvW;
    n.a((a)this);
    paramc = n.JvW;
    n.a((b)this);
    paramc = com.tencent.mm.plugin.hld.f.e.Jym;
    if (com.tencent.mm.plugin.hld.f.e.fOb())
    {
      paramc = f.Jor;
      Context localContext = getContext();
      s.s(localContext, "context");
      paramc.init(localContext);
    }
    AppMethodBeat.o(313273);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(313299);
    s.u(paramString, "text");
    s.u(paramArrayOfByte, "id");
    Object localObject = l.JyV;
    l.jC("WxIme.WxImeCandidateView", "onClick " + paramString + ", " + paramArrayOfByte + ", " + paramInt);
    localObject = com.tencent.mm.plugin.hld.model.g.JuL;
    int j = com.tencent.mm.plugin.hld.model.g.fMl();
    int i;
    switch (j)
    {
    case 2: 
    default: 
      i = 600;
      switch (j)
      {
      }
      break;
    }
    for (j = 1;; j = 3)
    {
      n.a(n.JvW, paramString, paramArrayOfByte, null, true, paramLong, false, 36);
      paramArrayOfByte = com.tencent.mm.plugin.hld.f.g.Jyo;
      com.tencent.mm.plugin.hld.f.g.jB("emoji", paramString);
      paramString = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.jr(j, paramInt);
      paramString = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.YA(i);
      AppMethodBeat.o(313299);
      return;
      i = 800;
      break;
    }
  }
  
  public final void a(ArrayList<Candidate> paramArrayList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(313309);
    s.u(paramArrayList, "addList");
    Object localObject1 = new StringBuilder("updateCandidates ").append(paramArrayList.size()).append(' ');
    Object localObject2 = MMApplicationContext.getContext().getResources();
    if (localObject2 == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.resources.MMResources");
      AppMethodBeat.o(313309);
      throw paramArrayList;
    }
    Log.d("WxIme.WxImeCandidateView", ((com.tencent.mm.ce.d)localObject2).mResources.getConfiguration().uiMode);
    this.Jns.clear();
    if (paramBoolean1)
    {
      localObject1 = getAssociationContainerRv();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "updateCandidateList", "(Ljava/util/ArrayList;IZZ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "updateCandidateList", "(Ljava/util/ArrayList;IZZ)V", "Undefined", "scrollToPosition", "(I)V");
    }
    this.Jns.addAll((Collection)paramArrayList);
    paramArrayList = getAssociationContainerRv().getAdapter();
    if (paramArrayList != null) {
      paramArrayList.bZE.notifyChanged();
    }
    wM(false);
    this.Jnw = false;
    this.Jnx = paramBoolean2;
    AppMethodBeat.o(313309);
  }
  
  public final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(313327);
    Object localObject = com.tencent.mm.plugin.hld.f.h.Jyy;
    localObject = getContext();
    s.s(localObject, "context");
    s.u(localObject, "context");
    paramArrayOfPendingInput = (CharSequence)com.tencent.mm.plugin.hld.f.h.a((Context)localObject, paramArrayOfPendingInput).bsC;
    localObject = com.tencent.mm.plugin.hld.model.g.JuL;
    if (com.tencent.mm.plugin.hld.model.g.fMj())
    {
      localObject = e.Jon;
      if (e.fKQ())
      {
        getStrikeTv().setText((CharSequence)getContext().getString(a.j.wxime_clipboard_desc));
        paramCharSequence = e.Jon;
        if (!e.fKQ()) {
          break label193;
        }
        getStrikeTv().setVisibility(0);
        getStrikeLogoContainerRl().setVisibility(8);
      }
    }
    label266:
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        this.Jog = bool;
        paramArrayOfPendingInput = com.tencent.mm.plugin.hld.model.g.JuL;
        com.tencent.mm.plugin.hld.model.g.ax(this.Jog, this.Joh);
        wO(false);
        AppMethodBeat.o(313327);
        return;
        localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
        if (localObject == null) {
          break;
        }
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.hld.a.b)localObject).b(paramArrayOfPendingInput, paramCharSequence);
        break;
        label193:
        getStrikeTv().setVisibility(8);
        getStrikeLogoContainerRl().setVisibility(0);
        if (Util.isNullOrNil(paramArrayOfPendingInput)) {
          break label266;
        }
      }
      if (Util.isNullOrNil(paramArrayOfPendingInput))
      {
        wM(true);
        d((CharSequence)"", true);
        AppMethodBeat.o(313327);
        return;
      }
      d(paramArrayOfPendingInput, true);
      AppMethodBeat.o(313327);
      return;
    }
  }
  
  public final void fKM()
  {
    AppMethodBeat.i(313332);
    wM(false);
    d((CharSequence)"", false);
    AppMethodBeat.o(313332);
  }
  
  public final void fKN()
  {
    AppMethodBeat.i(313341);
    com.tencent.threadpool.h.ahAA.g(new ImeCandidateView..ExternalSyntheticLambda0(this), "WxIme.WxImeCandidateViewrefreshEditText");
    AppMethodBeat.o(313341);
  }
  
  public final TextView getStrikeTv()
  {
    AppMethodBeat.i(313269);
    Object localObject = this.JnY.getValue();
    s.s(localObject, "<get-strikeTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(313269);
    return localObject;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(313285);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.right_container_ll;
      if (paramView != null) {
        break label119;
      }
      label53:
      i = a.f.pack_up_ll;
      if (paramView != null) {
        break label279;
      }
      label61:
      i = a.f.clip_board_tv;
      if (paramView != null) {
        break label348;
      }
      label69:
      i = a.f.strike_inner_container_ll;
      if (paramView != null) {
        break label463;
      }
      label77:
      i = a.f.account_container_rl;
      if (paramView != null) {
        break label615;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(313285);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label119:
      if (paramView.intValue() != i) {
        break label53;
      }
      if (getCloseIv().getVisibility() == 0)
      {
        Log.i("WxIme.WxImeCandidateView", "close ime");
        paramView = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if (paramView != null) {
            paramView.requestHideSelf(0);
          }
        }
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YA(801);
      }
      else if (getCloseClipboardIv().getVisibility() == 0)
      {
        Log.i("WxIme.WxImeCandidateView", "close clipboard");
        paramView = e.Jon;
        e.fKR();
        paramView = n.JvW;
        n.fMT();
        reset();
      }
      else
      {
        Log.i("WxIme.WxImeCandidateView", "switch to S6AlternativeWords");
        getNormalContainerRl().setVisibility(8);
        getPackUpContainerRl().setVisibility(0);
        com.tencent.mm.plugin.hld.model.g.JuL.a(com.tencent.mm.plugin.hld.keyboard.c.Jru);
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YA(601);
        continue;
        label279:
        if (paramView.intValue() != i) {
          break label61;
        }
        Log.i("WxIme.WxImeCandidateView", "close S6AlternativeWords");
        getNormalContainerRl().setVisibility(0);
        getPackUpContainerRl().setVisibility(8);
        getRightContainerLl().setVisibility(0);
        com.tencent.mm.plugin.hld.model.g.JuL.Yu(com.tencent.mm.plugin.hld.model.g.fMq());
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YA(602);
        wO(false);
        continue;
        label348:
        if (paramView.intValue() != i) {
          break label69;
        }
        Log.i("WxIme.WxImeCandidateView", s.X("clip_board_tv ", Integer.valueOf(getClipBoardTv().getScrollX())));
        if (getClipBoardTv().getScrollX() > 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(313285);
          return;
        }
        paramView = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if (paramView != null)
          {
            localObject1 = e.Jon;
            paramView.aj(e.fKS());
          }
        }
        paramView = e.Jon;
        e.fKR();
        reset();
        continue;
        label463:
        if (paramView.intValue() != i) {
          break label77;
        }
        Log.i("WxIme.WxImeCandidateView", "strike_inner_container_ll");
        paramView = com.tencent.mm.plugin.hld.f.e.Jym;
        if (com.tencent.mm.plugin.hld.f.e.fOb())
        {
          paramView = f.Jor;
          localObject1 = (View)getStrikeContainerRl();
          s.u(localObject1, "anchorView");
          Object localObject2 = f.Jou;
          if (localObject2 != null) {
            ((ImeEditText)localObject2).setImeEditTextCursorListener((com.tencent.mm.plugin.hld.view.d)paramView);
          }
          f.mF = (View)localObject1;
          localObject2 = new int[2];
          ((View)localObject1).getLocationOnScreen((int[])localObject2);
          i = localObject2[1];
          f.Jow = ((View)localObject1).getMeasuredHeight() + i;
          localObject1 = n.JvW;
          n.a((b)paramView);
          paramView = f.Jou;
          if (paramView != null)
          {
            paramView.fPq();
            localObject1 = n.JvW;
            paramView.setText(n.fMP());
            paramView.setSelection(paramView.getText().length());
            paramView.requestFocus();
          }
          f.fKT();
          continue;
          label615:
          if (paramView.intValue() == i)
          {
            Log.i("WxIme.WxImeCandidateView", "click account bar");
            paramView = new Intent();
            paramView.addFlags(268435456).addFlags(67108864);
            com.tencent.mm.br.c.g(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", paramView);
          }
        }
      }
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(313294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.logo_iv;
      if (paramView != null) {
        break label89;
      }
    }
    label89:
    while (paramView.intValue() != i)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(313294);
      return false;
      paramView = Integer.valueOf(paramView.getId());
      break;
    }
    com.tencent.mm.plugin.hld.model.g.JuL.wW(false);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(313294);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(313349);
    this.Joi = null;
    d((CharSequence)"", false);
    f.Jor.onHide();
    com.tencent.mm.plugin.hld.f.h localh = com.tencent.mm.plugin.hld.f.h.Jyy;
    com.tencent.mm.plugin.hld.f.h.reset();
    this.Jns.clear();
    wM(false);
    AppMethodBeat.o(313349);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    c(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    f(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    g(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    h(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<TextView>
  {
    i(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    j(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    k(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    l(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    m(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    n(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    o(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/HorizontalScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<HorizontalScrollView>
  {
    p(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    q(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<TextView>
  {
    r(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.ImeCandidateView
 * JD-Core Version:    0.7.0.1
 */