package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "ItemType", "OnListItemLongClickListener", "ScopeInfoViewHolder", "UserInfoViewHolder", "ViewHolder", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends RecyclerView.a<g>
{
  public static final k.c uCU;
  public List<a> bMQ;
  public b thf;
  public d uCV;
  
  static
  {
    AppMethodBeat.i(324721);
    uCU = new k.c((byte)0);
    AppMethodBeat.o(324721);
  }
  
  public k(List<a> paramList)
  {
    AppMethodBeat.i(324715);
    this.bMQ = paramList;
    AppMethodBeat.o(324715);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(324725);
    int i = this.bMQ.size();
    AppMethodBeat.o(324725);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(324730);
    a locala = (a)this.bMQ.get(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(324730);
      return 0;
    }
    paramInt = locala.type;
    AppMethodBeat.o(324730);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "", "type", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(ILjava/lang/String;Ljava/lang/String;Z)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "getType", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    String iconUrl;
    public boolean plZ;
    public int rFX;
    public final String scope;
    Bitmap tLg;
    final String title;
    final int type;
    final String uCW;
    
    public a(int paramInt1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(324736);
      this.type = paramInt1;
      this.title = paramString1;
      this.uCW = paramString2;
      this.scope = paramString3;
      this.tLg = paramBitmap;
      this.plZ = paramBoolean;
      this.iconUrl = paramString4;
      this.rFX = paramInt2;
      AppMethodBeat.o(324736);
    }
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, byte paramByte)
    {
      this(0, paramString1, paramString2, paramString3, paramBitmap, true, "", 0);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(0, paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(324748);
      AppMethodBeat.o(324748);
    }
    
    public a(String paramString1, String paramString2, boolean paramBoolean)
    {
      this(1, paramString1, "", paramString2, null, paramBoolean, "", 0);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(k.a parama);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(View paramView, k.a parama, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ScopeInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends k.g
  {
    private final TextView mll;
    private final ViewGroup parent;
    private final ImageView uCX;
    
    public e(ViewGroup paramViewGroup, List<k.a> paramList, k paramk)
    {
      super(paramList, paramk);
      AppMethodBeat.i(324729);
      this.parent = paramViewGroup;
      paramViewGroup = this.view.findViewById(a.d.title);
      s.s(paramViewGroup, "view.findViewById(R.id.title)");
      this.mll = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.selected);
      s.s(paramViewGroup, "view.findViewById(R.id.selected)");
      this.uCX = ((ImageView)paramViewGroup);
      AppMethodBeat.o(324729);
    }
    
    public final void c(k.a parama)
    {
      AppMethodBeat.i(324733);
      s.u(parama, "item");
      this.mll.setText((CharSequence)parama.title);
      AppMethodBeat.o(324733);
    }
    
    public final void ls(boolean paramBoolean)
    {
      AppMethodBeat.i(324741);
      if (paramBoolean)
      {
        this.mll.setContentDescription(this.mll.getText());
        this.uCX.setVisibility(0);
        this.uCX.setContentDescription((CharSequence)this.uCX.getContext().getString(a.g.app_brand_state_selected));
        AppMethodBeat.o(324741);
        return;
      }
      this.mll.setContentDescription((CharSequence)(this.mll.getText() + ' ' + this.uCX.getContext().getString(a.g.app_brand_state_unselected)));
      this.uCX.setVisibility(4);
      AppMethodBeat.o(324741);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends k.g
  {
    private ImageView dpM;
    private final TextView mll;
    private final ViewGroup parent;
    private final ImageView uCX;
    private final TextView uCY;
    
    public f(ViewGroup paramViewGroup, List<k.a> paramList, k paramk)
    {
      super(paramList, paramk);
      AppMethodBeat.i(324747);
      this.parent = paramViewGroup;
      paramViewGroup = this.view.findViewById(a.d.icon);
      s.s(paramViewGroup, "view.findViewById(R.id.icon)");
      this.dpM = ((ImageView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.title);
      s.s(paramViewGroup, "view.findViewById(R.id.title)");
      this.mll = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.sub_title);
      s.s(paramViewGroup, "view.findViewById(R.id.sub_title)");
      this.uCY = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.selected);
      s.s(paramViewGroup, "view.findViewById(R.id.selected)");
      this.uCX = ((ImageView)paramViewGroup);
      this.view.setImportantForAccessibility(1);
      this.uCY.setImportantForAccessibility(2);
      AppMethodBeat.o(324747);
    }
    
    public final void c(k.a parama)
    {
      AppMethodBeat.i(324753);
      s.u(parama, "item");
      this.dpM.setImageResource(a.c.default_avatar);
      TextView localTextView = this.mll;
      Object localObject = com.tencent.mm.plugin.appbrand.widget.input.a.a.cSb().a(this.mll.getContext(), (CharSequence)parama.title, this.mll.getTextSize());
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        localTextView.setText((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)parama.uCW)) {
          break label186;
        }
        this.uCY.setVisibility(0);
        localTextView = this.uCY;
        localObject = parama.uCW;
        if (localObject != null) {
          break label178;
        }
        localObject = (CharSequence)"";
        label115:
        localTextView.setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (parama.tLg != null)
        {
          parama = BitmapUtil.getRoundedCornerBitmap(parama.tLg, false, com.tencent.mm.cd.a.fromDPToPix(this.view.getContext(), 4) * 1.0F, false);
          if (parama != null)
          {
            this.dpM.setImageBitmap(parama);
            AppMethodBeat.o(324753);
            return;
            localObject = (CharSequence)localObject;
            break;
            label178:
            localObject = (CharSequence)localObject;
            break label115;
            label186:
            this.uCY.setVisibility(8);
            continue;
          }
          this.dpM.setImageResource(a.c.default_avatar);
          AppMethodBeat.o(324753);
          return;
        }
      }
      if (((CharSequence)parama.iconUrl).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          com.tencent.mm.modelappbrand.a.b.bEY().a(this.dpM, parama.iconUrl, a.c.default_avatar, (b.h)new a(this));
        }
        AppMethodBeat.o(324753);
        return;
      }
    }
    
    public final void ls(boolean paramBoolean)
    {
      AppMethodBeat.i(324758);
      if (paramBoolean)
      {
        this.mll.setContentDescription(this.mll.getText());
        this.uCX.setVisibility(0);
        this.uCX.setContentDescription((CharSequence)this.uCX.getContext().getString(a.g.app_brand_state_selected));
        AppMethodBeat.o(324758);
        return;
      }
      this.mll.setContentDescription((CharSequence)(this.mll.getText() + ' ' + this.uCX.getContext().getString(a.g.app_brand_state_unselected)));
      this.uCX.setVisibility(4);
      AppMethodBeat.o(324758);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder$reanderView$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b.h
    {
      a(k.f paramf) {}
      
      public final Bitmap P(Bitmap paramBitmap)
      {
        AppMethodBeat.i(324712);
        s.u(paramBitmap, "bitmap");
        paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, com.tencent.mm.cd.a.fromDPToPix(this.uCZ.view.getContext(), 4) * 1.0F, false);
        s.s(paramBitmap, "getRoundedCornerBitmap(b…ontext, 4) * 1.0f, false)");
        AppMethodBeat.o(324712);
        return paramBitmap;
      }
      
      public final String key()
      {
        return "appbrand_user_avatar";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getItems", "()Ljava/util/List;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "reanderView", "refreshCheckView", "check", "", "renderViewChecked", "checked", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class g
    extends RecyclerView.v
  {
    private final List<k.a> bMQ;
    private final k uDa;
    View view;
    
    public g(View paramView, List<k.a> paramList, k paramk)
    {
      super();
      this.view = paramView;
      this.bMQ = paramList;
      this.uDa = paramk;
    }
    
    private static final void a(k.a parama, g paramg, kotlin.g.a.b paramb, int paramInt, View paramView)
    {
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramg);
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$item");
      s.u(paramg, "this$0");
      s.u(paramb, "$checkStateChange");
      parama.plZ = true;
      paramg.a(parama.plZ, parama);
      parama = new ArrayList();
      paramg = ((Iterable)paramg.bMQ).iterator();
      int i = 0;
      if (paramg.hasNext())
      {
        paramView = paramg.next();
        if (i < 0) {
          p.kkW();
        }
        paramView = (k.a)paramView;
        parama.add(Integer.valueOf(i));
        if (paramInt != i) {
          if ((paramView == null) || (paramView.plZ != true)) {
            break label217;
          }
        }
        label217:
        for (int j = 1;; j = 0)
        {
          if (j != 0)
          {
            paramView.plZ = false;
            parama.add(Integer.valueOf(paramInt));
          }
          i += 1;
          break;
        }
      }
      paramb.invoke(parama);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
    
    private final void a(boolean paramBoolean, k.a parama)
    {
      k.b localb;
      if (this.bMQ.size() == 1)
      {
        ls(true);
        if (paramBoolean)
        {
          localb = this.uDa.thf;
          if (localb != null) {
            localb.a(parama);
          }
        }
        return;
      }
      if (paramBoolean)
      {
        localb = this.uDa.thf;
        if (localb != null) {
          localb.a(parama);
        }
        ls(true);
        return;
      }
      ls(false);
    }
    
    private static final boolean a(g paramg, k.a parama, int paramInt, View paramView)
    {
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramg);
      localb.cH(parama);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      s.u(paramg, "this$0");
      s.u(parama, "$item");
      paramView = paramg.uDa.uCV;
      if (paramView != null) {
        paramView.a(paramg.view, parama, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return true;
    }
    
    public final void a(k.a parama, int paramInt, kotlin.g.a.b<? super ArrayList<Integer>, ah> paramb)
    {
      s.u(parama, "item");
      s.u(paramb, "checkStateChange");
      c(parama);
      a(parama.plZ, parama);
      this.view.setOnClickListener(new k.g..ExternalSyntheticLambda0(parama, this, paramb, paramInt));
      this.view.setOnLongClickListener(new k.g..ExternalSyntheticLambda1(this, parama, paramInt));
    }
    
    public abstract void c(k.a parama);
    
    public abstract void ls(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.k
 * JD-Core Version:    0.7.0.1
 */