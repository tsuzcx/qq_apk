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
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeEditText;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.PendingInput;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateViewHolder$ICandidateListener;", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "accountContainerRl", "Landroid/widget/RelativeLayout;", "getAccountContainerRl", "()Landroid/widget/RelativeLayout;", "accountContainerRl$delegate", "Lkotlin/Lazy;", "associationContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getAssociationContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "associationContainerRv$delegate", "candidateList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "candidateListfetching", "", "clipBoardContainerRv", "getClipBoardContainerRv", "clipBoardContainerRv$delegate", "clipBoardTv", "Landroid/widget/TextView;", "getClipBoardTv", "()Landroid/widget/TextView;", "clipBoardTv$delegate", "closeClipboardIv", "Landroid/widget/ImageView;", "getCloseClipboardIv", "()Landroid/widget/ImageView;", "closeClipboardIv$delegate", "closeIv", "getCloseIv", "closeIv$delegate", "hasClipboardContent", "hasMoreCandidate", "hasStrikeContent", "ifEditTextEmpty", "Ljava/lang/Boolean;", "logoIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLogoIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "logoIv$delegate", "mIKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "nameIv", "getNameIv", "nameIv$delegate", "normalContainerRl", "getNormalContainerRl", "normalContainerRl$delegate", "packUpContainerRl", "getPackUpContainerRl", "packUpContainerRl$delegate", "packUpLl", "getPackUpLl", "packUpLl$delegate", "rightContainerLl", "getRightContainerLl", "rightContainerLl$delegate", "shapeIv", "getShapeIv", "shapeIv$delegate", "strikeContainerRl", "getStrikeContainerRl", "strikeContainerRl$delegate", "strikeContainerSv", "Landroid/widget/HorizontalScrollView;", "getStrikeContainerSv", "()Landroid/widget/HorizontalScrollView;", "strikeContainerSv$delegate", "strikeLogoContainerRl", "getStrikeLogoContainerRl", "strikeLogoContainerRl$delegate", "strikeTv", "getStrikeTv", "strikeTv$delegate", "ifShieldCandidateView", "init", "", "listener", "onClick", "v", "Landroid/view/View;", "text", "", "id", "", "order", "pressTime", "", "onLongClick", "onResume", "refreshCandidateView", "fromPendingInput", "refreshEditText", "reset", "scrollBy", "distance", "showCandidateView", "showClipBoard", "showClipboardContent", "updateCandidateByStatus", "updateCandidateList", "addList", "type", "newList", "hasMore", "updateEnglishStrikeView", "pendingInputText", "", "lastPendingInputContent", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "cursorIndex", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "updateStrikeView", "Companion", "plugin-hld_release"})
public final class ImeCandidateView
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener, a, b, d.a
{
  public static final a DuK;
  private final ArrayList<Candidate> DtS;
  private boolean DtV;
  private boolean DtW;
  private final kotlin.f DuA;
  private final kotlin.f DuB;
  private final kotlin.f DuC;
  private final kotlin.f DuD;
  private final kotlin.f DuE;
  private final kotlin.f DuF;
  private final kotlin.f DuG;
  private boolean DuH;
  private boolean DuI;
  private Boolean DuJ;
  private com.tencent.mm.plugin.hld.a.c Dup;
  private final kotlin.f Duq;
  private final kotlin.f Dur;
  private final kotlin.f Dus;
  private final kotlin.f Dut;
  private final kotlin.f Duu;
  private final kotlin.f Duv;
  private final kotlin.f Duw;
  private final kotlin.f Dux;
  private final kotlin.f Duy;
  private final kotlin.f Duz;
  
  static
  {
    AppMethodBeat.i(213712);
    DuK = new a((byte)0);
    AppMethodBeat.o(213712);
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
    AppMethodBeat.i(213707);
    this.Duq = kotlin.g.ar((kotlin.g.a.a)new r(this));
    this.Dur = kotlin.g.ar((kotlin.g.a.a)new q(this));
    this.Dus = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.Dut = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Duu = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.Duv = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.Duw = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.Dux = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.Duy = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.Duz = kotlin.g.ar((kotlin.g.a.a)new t(this));
    this.DuA = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.DuB = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.DuC = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.DuD = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.DuE = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.DuF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.DuG = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.DtS = new ArrayList();
    ad.kS(getContext()).inflate(a.h.ime_candidate_container, (ViewGroup)this, true);
    setOrientation(1);
    paramContext = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getRightContainerLl(), (View.OnClickListener)this);
    paramContext = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getClipBoardTv(), (View.OnClickListener)this);
    paramContext = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getPackUpLl(), (View.OnClickListener)this);
    paramContext = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getStrikeContainerRl(), (View.OnClickListener)this);
    paramContext = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getAccountContainerRl(), (View.OnClickListener)this);
    getStrikeTv().addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(213868);
        ImeCandidateView.m(this.DuL).post((Runnable)new a(this));
        AppMethodBeat.o(213868);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(ImeCandidateView.1 param1) {}
        
        public final void run()
        {
          AppMethodBeat.i(215870);
          ImeCandidateView.m(this.DuM.DuL).scrollTo(ImeCandidateView.m(this.DuM.DuL).getWidth(), 0);
          AppMethodBeat.o(215870);
        }
      }
    });
    getAssociationContainerRv().setAdapter((RecyclerView.a)new c(this.DtS, (d.a)this));
    paramContext = new WxLinearLayoutManager(getContext());
    paramContext.setOrientation(0);
    getAssociationContainerRv().setLayoutManager((RecyclerView.LayoutManager)paramContext);
    getAssociationContainerRv().a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(209036);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        if (ImeCandidateView.n(this.DuL).isEmpty())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(209034);
          return;
        }
        if ((ImeCandidateView.o(this.DuL)) && (!ImeCandidateView.p(this.DuL)) && (ImeCandidateView.n(this.DuL).size() - paramContext.kL() <= 5))
        {
          ImeCandidateView.q(this.DuL);
          paramAnonymousRecyclerView = n.DEn;
          n.eEN();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(209034);
      }
    });
    paramContext = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      getNameIv().setVisibility(0);
      getLogoIv().setVisibility(8);
      AppMethodBeat.o(213707);
      return;
    }
    getNameIv().setVisibility(8);
    getLogoIv().setVisibility(0);
    getLogoIv().setOnLongClickListener((View.OnLongClickListener)this);
    AppMethodBeat.o(213707);
  }
  
  private final void d(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(213701);
    e locale = e.DuU;
    if (e.eCO())
    {
      getStrikeTv().setText((CharSequence)getContext().getString(a.j.wxime_clipboard_desc));
      paramCharSequence = e.DuU;
      if (!e.eCO()) {
        break label106;
      }
      getStrikeTv().setVisibility(0);
      getStrikeLogoContainerRl().setVisibility(8);
      this.DuH = false;
    }
    for (;;)
    {
      paramCharSequence = com.tencent.mm.plugin.hld.model.g.DCm;
      com.tencent.mm.plugin.hld.model.g.af(this.DuH, this.DuI);
      sI(paramBoolean);
      AppMethodBeat.o(213701);
      return;
      getStrikeTv().setText(paramCharSequence);
      break;
      label106:
      if (Util.isNullOrNil(getStrikeTv().getText().toString()))
      {
        getStrikeTv().setVisibility(8);
        getStrikeLogoContainerRl().setVisibility(0);
        this.DuH = false;
      }
      else
      {
        getStrikeTv().setVisibility(0);
        getStrikeLogoContainerRl().setVisibility(8);
        this.DuH = true;
      }
    }
  }
  
  private static boolean eCL()
  {
    AppMethodBeat.i(213704);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      switch (com.tencent.mm.plugin.hld.model.g.eEj())
      {
      case 2: 
      default: 
        AppMethodBeat.o(213704);
        return false;
      }
      AppMethodBeat.o(213704);
      return true;
    }
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    if (com.tencent.mm.plugin.hld.model.g.eEn())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyo))
      {
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyn)) {}
      }
      else
      {
        AppMethodBeat.o(213704);
        return true;
      }
    }
    AppMethodBeat.o(213704);
    return false;
  }
  
  private final RelativeLayout getAccountContainerRl()
  {
    AppMethodBeat.i(213684);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DuG.getValue();
    AppMethodBeat.o(213684);
    return localRelativeLayout;
  }
  
  private final RecyclerView getAssociationContainerRv()
  {
    AppMethodBeat.i(213683);
    RecyclerView localRecyclerView = (RecyclerView)this.DuF.getValue();
    AppMethodBeat.o(213683);
    return localRecyclerView;
  }
  
  private final RelativeLayout getClipBoardContainerRv()
  {
    AppMethodBeat.i(213681);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DuD.getValue();
    AppMethodBeat.o(213681);
    return localRelativeLayout;
  }
  
  private final TextView getClipBoardTv()
  {
    AppMethodBeat.i(213682);
    TextView localTextView = (TextView)this.DuE.getValue();
    AppMethodBeat.o(213682);
    return localTextView;
  }
  
  private final ImageView getCloseClipboardIv()
  {
    AppMethodBeat.i(213679);
    ImageView localImageView = (ImageView)this.DuB.getValue();
    AppMethodBeat.o(213679);
    return localImageView;
  }
  
  private final ImageView getCloseIv()
  {
    AppMethodBeat.i(213680);
    ImageView localImageView = (ImageView)this.DuC.getValue();
    AppMethodBeat.o(213680);
    return localImageView;
  }
  
  private final WeImageView getLogoIv()
  {
    AppMethodBeat.i(213663);
    WeImageView localWeImageView = (WeImageView)this.Dut.getValue();
    AppMethodBeat.o(213663);
    return localWeImageView;
  }
  
  private final TextView getNameIv()
  {
    AppMethodBeat.i(213667);
    TextView localTextView = (TextView)this.Duu.getValue();
    AppMethodBeat.o(213667);
    return localTextView;
  }
  
  private final RelativeLayout getNormalContainerRl()
  {
    AppMethodBeat.i(213668);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Duv.getValue();
    AppMethodBeat.o(213668);
    return localRelativeLayout;
  }
  
  private final RelativeLayout getPackUpContainerRl()
  {
    AppMethodBeat.i(213670);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Duw.getValue();
    AppMethodBeat.o(213670);
    return localRelativeLayout;
  }
  
  private final RelativeLayout getPackUpLl()
  {
    AppMethodBeat.i(213674);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Duy.getValue();
    AppMethodBeat.o(213674);
    return localRelativeLayout;
  }
  
  private final RelativeLayout getRightContainerLl()
  {
    AppMethodBeat.i(213673);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dux.getValue();
    AppMethodBeat.o(213673);
    return localRelativeLayout;
  }
  
  private final ImageView getShapeIv()
  {
    AppMethodBeat.i(213677);
    ImageView localImageView = (ImageView)this.DuA.getValue();
    AppMethodBeat.o(213677);
    return localImageView;
  }
  
  private final RelativeLayout getStrikeContainerRl()
  {
    AppMethodBeat.i(213658);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dur.getValue();
    AppMethodBeat.o(213658);
    return localRelativeLayout;
  }
  
  private final HorizontalScrollView getStrikeContainerSv()
  {
    AppMethodBeat.i(213656);
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.Duq.getValue();
    AppMethodBeat.o(213656);
    return localHorizontalScrollView;
  }
  
  private final RelativeLayout getStrikeLogoContainerRl()
  {
    AppMethodBeat.i(213660);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dus.getValue();
    AppMethodBeat.o(213660);
    return localRelativeLayout;
  }
  
  private final void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(213699);
    Object localObject = n.DEn;
    if (n.eEE())
    {
      localObject = e.DuU;
      if (e.eCO()) {
        sH(true);
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      com.tencent.mm.plugin.hld.model.g.af(this.DuH, this.DuI);
      sI(paramBoolean);
      AppMethodBeat.o(213699);
      return;
      sH(false);
    }
  }
  
  private final void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(213700);
    if (paramBoolean)
    {
      getAssociationContainerRv().setVisibility(8);
      getClipBoardContainerRv().setVisibility(0);
      TextView localTextView = getClipBoardTv();
      e locale = e.DuU;
      localTextView.setText(e.eCQ());
      getClipBoardTv().setHorizontallyScrolling(true);
      getClipBoardTv().setMovementMethod(ScrollingMovementMethod.getInstance());
      getClipBoardTv().scrollTo(0, 0);
      this.DuI = true;
      AppMethodBeat.o(213700);
      return;
    }
    if (eCL()) {
      getAssociationContainerRv().setVisibility(8);
    }
    for (;;)
    {
      getClipBoardContainerRv().setVisibility(8);
      this.DuI = false;
      AppMethodBeat.o(213700);
      return;
      getAssociationContainerRv().setVisibility(0);
    }
  }
  
  private void sI(final boolean paramBoolean)
  {
    AppMethodBeat.i(213702);
    com.tencent.e.h.ZvG.bc((Runnable)new u(this, paramBoolean));
    AppMethodBeat.o(213702);
  }
  
  public final void Ur(final int paramInt)
  {
    AppMethodBeat.i(213691);
    getAccountContainerRl().post((Runnable)new o(this, paramInt));
    AppMethodBeat.o(213691);
  }
  
  public final void a(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(213685);
    this.Dup = paramc;
    paramc = n.DEn;
    n.a((a)this);
    paramc = n.DEn;
    n.a((b)this);
    paramc = com.tencent.mm.plugin.hld.f.e.DGW;
    if (com.tencent.mm.plugin.hld.f.e.eGp())
    {
      paramc = f.Dvh;
      Context localContext = getContext();
      p.j(localContext, "context");
      paramc.init(localContext);
    }
    AppMethodBeat.o(213685);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(213688);
    p.k(paramString, "text");
    p.k(paramArrayOfByte, "id");
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.WxImeCandidateView", "onClick " + paramString + ", " + paramArrayOfByte + ", " + paramInt);
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    int j = com.tencent.mm.plugin.hld.model.g.eEj();
    int i;
    if ((j == 3) || (j == 1))
    {
      i = 800;
      if ((j != 3) && (j != 1)) {
        break label171;
      }
    }
    label171:
    for (j = 3;; j = 1)
    {
      n.a(n.DEn, paramString, paramArrayOfByte, null, true, paramLong, false, 36);
      paramArrayOfByte = com.tencent.mm.plugin.hld.f.g.DHh;
      com.tencent.mm.plugin.hld.f.g.is("emoji", paramString);
      paramString = k.DDb;
      k.hN(j, paramInt);
      paramString = k.DDb;
      k.hO(i, 1);
      AppMethodBeat.o(213688);
      return;
      i = 600;
      break;
    }
  }
  
  public final void a(ArrayList<Candidate> paramArrayList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213690);
    p.k(paramArrayList, "addList");
    Object localObject1 = new StringBuilder("updateCandidates ").append(paramArrayList.size()).append(' ');
    Object localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.resources.MMResources");
      AppMethodBeat.o(213690);
      throw paramArrayList;
    }
    localObject2 = ((com.tencent.mm.cj.b)localObject2).hrw();
    p.j(localObject2, "(MMApplicationContext.ge…esources).systemResources");
    Log.d("WxIme.WxImeCandidateView", ((Resources)localObject2).getConfiguration().uiMode);
    this.DtS.clear();
    if (paramBoolean1)
    {
      localObject1 = getAssociationContainerRv();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "updateCandidateList", "(Ljava/util/ArrayList;IZZ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "updateCandidateList", "(Ljava/util/ArrayList;IZZ)V", "Undefined", "scrollToPosition", "(I)V");
    }
    this.DtS.addAll((Collection)paramArrayList);
    paramArrayList = getAssociationContainerRv().getAdapter();
    if (paramArrayList != null) {
      paramArrayList.notifyDataSetChanged();
    }
    sG(false);
    this.DtV = false;
    this.DtW = paramBoolean2;
    AppMethodBeat.o(213690);
  }
  
  public final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(213693);
    Object localObject = com.tencent.mm.plugin.hld.f.h.DHl;
    localObject = getContext();
    p.j(localObject, "context");
    p.k(localObject, "context");
    paramArrayOfPendingInput = (CharSequence)com.tencent.mm.plugin.hld.f.h.a((Context)localObject, paramArrayOfPendingInput).Mx;
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    if (com.tencent.mm.plugin.hld.model.g.eEh())
    {
      localObject = e.DuU;
      if (e.eCO())
      {
        getStrikeTv().setText((CharSequence)getContext().getString(a.j.wxime_clipboard_desc));
        paramCharSequence = e.DuU;
        if (!e.eCO()) {
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
        this.DuH = bool;
        paramArrayOfPendingInput = com.tencent.mm.plugin.hld.model.g.DCm;
        com.tencent.mm.plugin.hld.model.g.af(this.DuH, this.DuI);
        sI(false);
        AppMethodBeat.o(213693);
        return;
        localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (localObject == null) {
          break;
        }
        localObject = ((d)localObject).eCD();
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
        sG(true);
        d((CharSequence)"", true);
        AppMethodBeat.o(213693);
        return;
      }
      d(paramArrayOfPendingInput, true);
      AppMethodBeat.o(213693);
      return;
    }
  }
  
  public final void eCJ()
  {
    AppMethodBeat.i(213694);
    sG(false);
    d((CharSequence)"", false);
    AppMethodBeat.o(213694);
  }
  
  public final void eCK()
  {
    AppMethodBeat.i(213696);
    com.tencent.e.h.ZvG.d((Runnable)new m(this), "WxIme.WxImeCandidateViewrefreshEditText");
    AppMethodBeat.o(213696);
  }
  
  public final TextView getStrikeTv()
  {
    AppMethodBeat.i(213675);
    TextView localTextView = (TextView)this.Duz.getValue();
    AppMethodBeat.o(213675);
    return localTextView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213686);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.right_container_ll;
      if (paramView != null) {
        break label119;
      }
      label59:
      i = a.f.pack_up_ll;
      if (paramView != null) {
        break label281;
      }
      label67:
      i = a.f.clip_board_tv;
      if (paramView != null) {
        break label351;
      }
      label75:
      i = a.f.strike_inner_container_ll;
      if (paramView != null) {
        break label473;
      }
      label83:
      i = a.f.account_container_rl;
      if (paramView != null) {
        break label625;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213686);
      return;
      paramView = null;
      break;
      label119:
      if (paramView.intValue() != i) {
        break label59;
      }
      if (getCloseIv().getVisibility() == 0)
      {
        Log.i("WxIme.WxImeCandidateView", "close ime");
        paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (paramView != null)
        {
          paramView = paramView.eCD();
          if (paramView != null) {
            paramView.requestHideSelf(0);
          }
        }
        paramView = k.DDb;
        k.hO(801, 1);
      }
      else if (getCloseClipboardIv().getVisibility() == 0)
      {
        Log.i("WxIme.WxImeCandidateView", "close clipboard");
        paramView = e.DuU;
        e.eCP();
        paramView = n.DEn;
        n.eEQ();
        reset();
      }
      else
      {
        Log.i("WxIme.WxImeCandidateView", "switch to S6AlternativeWords");
        getNormalContainerRl().setVisibility(8);
        getPackUpContainerRl().setVisibility(0);
        com.tencent.mm.plugin.hld.model.g.DCm.a(com.tencent.mm.plugin.hld.keyboard.c.Dyq);
        paramView = k.DDb;
        k.hO(601, 1);
        continue;
        label281:
        if (paramView.intValue() != i) {
          break label67;
        }
        Log.i("WxIme.WxImeCandidateView", "close S6AlternativeWords");
        getNormalContainerRl().setVisibility(0);
        getPackUpContainerRl().setVisibility(8);
        getRightContainerLl().setVisibility(0);
        com.tencent.mm.plugin.hld.model.g.DCm.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
        paramView = k.DDb;
        k.hO(602, 1);
        sI(false);
        continue;
        label351:
        if (paramView.intValue() != i) {
          break label75;
        }
        Log.i("WxIme.WxImeCandidateView", "clip_board_tv " + getClipBoardTv().getScrollX());
        if (getClipBoardTv().getScrollX() > 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213686);
          return;
        }
        paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (paramView != null)
        {
          paramView = paramView.eCD();
          if (paramView != null)
          {
            localObject1 = e.DuU;
            paramView.aa(e.eCQ());
          }
        }
        paramView = e.DuU;
        e.eCP();
        reset();
        continue;
        label473:
        if (paramView.intValue() != i) {
          break label83;
        }
        Log.i("WxIme.WxImeCandidateView", "strike_inner_container_ll");
        paramView = com.tencent.mm.plugin.hld.f.e.DGW;
        if (com.tencent.mm.plugin.hld.f.e.eGp())
        {
          paramView = f.Dvh;
          localObject1 = (View)getStrikeContainerRl();
          p.k(localObject1, "anchorView");
          Object localObject2 = f.DuX;
          if (localObject2 != null) {
            ((ImeEditText)localObject2).setImeEditTextCursorListener((com.tencent.mm.plugin.hld.view.e)paramView);
          }
          f.lJ = (View)localObject1;
          localObject2 = new int[2];
          ((View)localObject1).getLocationOnScreen((int[])localObject2);
          i = localObject2[1];
          f.DuZ = ((View)localObject1).getMeasuredHeight() + i;
          localObject1 = n.DEn;
          n.a((b)paramView);
          paramView = f.DuX;
          if (paramView != null)
          {
            paramView.eHE();
            localObject1 = n.DEn;
            paramView.setText(n.eEM());
            paramView.setSelection(paramView.getText().length());
            paramView.requestFocus();
          }
          f.eCR();
          continue;
          label625:
          if (paramView.intValue() == i)
          {
            Log.i("WxIme.WxImeCandidateView", "click account bar");
            paramView = new Intent();
            paramView.addFlags(268435456).addFlags(67108864);
            com.tencent.mm.by.c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", paramView);
          }
        }
      }
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(213687);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.logo_iv;
      if (paramView != null) {
        break label89;
      }
    }
    label89:
    while (paramView.intValue() != i)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(213687);
      return false;
      paramView = null;
      break;
    }
    com.tencent.mm.plugin.hld.model.g.DCm.sQ(false);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/candidate/ImeCandidateView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(213687);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(213706);
    this.DuJ = null;
    d((CharSequence)"", false);
    f.Dvh.onHide();
    com.tencent.mm.plugin.hld.f.h localh = com.tencent.mm.plugin.hld.f.h.DHl;
    com.tencent.mm.plugin.hld.f.h.reset();
    this.DtS.clear();
    sG(false);
    AppMethodBeat.o(213706);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    c(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    g(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    h(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<TextView>
  {
    i(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    j(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    k(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    l(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(ImeCandidateView paramImeCandidateView) {}
    
    public final void run()
    {
      AppMethodBeat.i(211603);
      Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      boolean bool = com.tencent.mm.plugin.hld.f.l.eGY();
      Log.i("WxIme.WxImeCandidateView", "refreshEditText " + ImeCandidateView.c(this.DuL) + ' ' + bool);
      if ((p.h(ImeCandidateView.c(this.DuL), Boolean.valueOf(bool)) ^ true))
      {
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        com.tencent.mm.plugin.hld.model.g.af(ImeCandidateView.d(this.DuL), ImeCandidateView.e(this.DuL));
        ImeCandidateView.a(this.DuL);
      }
      ImeCandidateView.a(this.DuL, Boolean.valueOf(bool));
      AppMethodBeat.o(211603);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    n(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(ImeCandidateView paramImeCandidateView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(210638);
      ImeCandidateView.b(this.DuL).scrollBy(paramInt, 0);
      AppMethodBeat.o(210638);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    p(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    q(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/HorizontalScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<HorizontalScrollView>
  {
    r(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    s(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<TextView>
  {
    t(ImeCandidateView paramImeCandidateView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(ImeCandidateView paramImeCandidateView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(217761);
      Object localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      int i = com.tencent.mm.plugin.hld.model.g.eEj();
      switch (i)
      {
      }
      for (;;)
      {
        if (ImeCandidateView.eCM())
        {
          ImeCandidateView.b(this.DuL).setVisibility(8);
          if (i != 4)
          {
            ImeCandidateView.j(this.DuL).setVisibility(0);
            ImeCandidateView.l(this.DuL).setVisibility(8);
          }
        }
        AppMethodBeat.o(217761);
        return;
        ImeCandidateView.f(this.DuL).setVisibility(0);
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eCE())
        {
          ImeCandidateView.g(this.DuL).setVisibility(8);
          ImeCandidateView.b(this.DuL).setVisibility(0);
        }
        for (;;)
        {
          ImeCandidateView.h(this.DuL).setVisibility(8);
          ImeCandidateView.i(this.DuL).setVisibility(0);
          ImeCandidateView.j(this.DuL).setVisibility(0);
          ImeCandidateView.k(this.DuL).setVisibility(8);
          ImeCandidateView.l(this.DuL).setVisibility(8);
          break;
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          if (!com.tencent.mm.plugin.hld.f.l.biq())
          {
            localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
            if (localObject != null)
            {
              localObject = ((d)localObject).eCD();
              if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).eCu() != true)) {}
            }
          }
          else
          {
            ImeCandidateView.g(this.DuL).setVisibility(8);
            ImeCandidateView.b(this.DuL).setVisibility(0);
            continue;
          }
          ImeCandidateView.g(this.DuL).setVisibility(0);
          ImeCandidateView.b(this.DuL).setVisibility(8);
        }
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        if ((com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyq)) && (paramBoolean))
        {
          ImeCandidateView.f(this.DuL).setVisibility(8);
          ImeCandidateView.b(this.DuL).setVisibility(8);
          ImeCandidateView.h(this.DuL).setVisibility(0);
          ImeCandidateView.i(this.DuL).setVisibility(8);
        }
        else
        {
          ImeCandidateView.f(this.DuL).setVisibility(0);
          ImeCandidateView.b(this.DuL).setVisibility(0);
          ImeCandidateView.g(this.DuL).setVisibility(8);
          ImeCandidateView.h(this.DuL).setVisibility(8);
          ImeCandidateView.i(this.DuL).setVisibility(0);
          ImeCandidateView.j(this.DuL).setVisibility(0);
          ImeCandidateView.k(this.DuL).setVisibility(8);
          ImeCandidateView.l(this.DuL).setVisibility(8);
          continue;
          localObject = com.tencent.mm.plugin.hld.model.g.DCm;
          if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyq))
          {
            ImeCandidateView.f(this.DuL).setVisibility(8);
            ImeCandidateView.b(this.DuL).setVisibility(8);
            ImeCandidateView.h(this.DuL).setVisibility(0);
            ImeCandidateView.i(this.DuL).setVisibility(8);
          }
          else
          {
            ImeCandidateView.f(this.DuL).setVisibility(0);
            ImeCandidateView.b(this.DuL).setVisibility(0);
            ImeCandidateView.g(this.DuL).setVisibility(8);
            ImeCandidateView.h(this.DuL).setVisibility(8);
            ImeCandidateView.i(this.DuL).setVisibility(0);
            ImeCandidateView.j(this.DuL).setVisibility(8);
            ImeCandidateView.k(this.DuL).setVisibility(8);
            ImeCandidateView.l(this.DuL).setVisibility(0);
            continue;
            ImeCandidateView.f(this.DuL).setVisibility(0);
            ImeCandidateView.b(this.DuL).setVisibility(8);
            ImeCandidateView.g(this.DuL).setVisibility(8);
            ImeCandidateView.h(this.DuL).setVisibility(8);
            ImeCandidateView.i(this.DuL).setVisibility(0);
            ImeCandidateView.j(this.DuL).setVisibility(8);
            ImeCandidateView.k(this.DuL).setVisibility(0);
            ImeCandidateView.l(this.DuL).setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.ImeCandidateView
 * JD-Core Version:    0.7.0.1
 */