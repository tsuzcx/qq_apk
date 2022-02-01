package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "ItemType", "OnListItemLongClickListener", "ScopeInfoViewHolder", "UserInfoViewHolder", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class h
  extends RecyclerView.a<g>
{
  public static final h.c rsv;
  public List<a> lxh;
  public b qcl;
  public d rsu;
  
  static
  {
    AppMethodBeat.i(240205);
    rsv = new h.c((byte)0);
    AppMethodBeat.o(240205);
  }
  
  public h(List<a> paramList)
  {
    AppMethodBeat.i(240203);
    this.lxh = paramList;
    AppMethodBeat.o(240203);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(240194);
    int i = this.lxh.size();
    AppMethodBeat.o(240194);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(240200);
    a locala = (a)this.lxh.get(paramInt);
    if (locala != null)
    {
      paramInt = locala.type;
      AppMethodBeat.o(240200);
      return paramInt;
    }
    AppMethodBeat.o(240200);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "", "type", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(ILjava/lang/String;Ljava/lang/String;Z)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "getType", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    String iconUrl;
    public boolean msB;
    public int oCE;
    Bitmap qGu;
    final String rsw;
    public final String scope;
    final String title;
    final int type;
    
    public a(int paramInt1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(247009);
      this.type = paramInt1;
      this.title = paramString1;
      this.rsw = paramString2;
      this.scope = paramString3;
      this.qGu = paramBitmap;
      this.msB = paramBoolean;
      this.iconUrl = paramString4;
      this.oCE = paramInt2;
      AppMethodBeat.o(247009);
    }
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, byte paramByte)
    {
      this(0, paramString1, paramString2, paramString3, paramBitmap, true, "", 0);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(0, paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(247012);
      AppMethodBeat.o(247012);
    }
    
    public a(String paramString1, String paramString2, boolean paramBoolean)
    {
      this(1, paramString1, "", paramString2, null, paramBoolean, "", 0);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(h.a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface d
  {
    public abstract void a(View paramView, h.a parama, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ScopeInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"})
  public static final class e
    extends h.g
  {
    private final TextView jMg;
    private final ViewGroup parent;
    private final ImageView rsx;
    
    public e(ViewGroup paramViewGroup, List<h.a> paramList, h paramh)
    {
      super(paramList, paramh);
      AppMethodBeat.i(244536);
      this.parent = paramViewGroup;
      paramViewGroup = this.view.findViewById(a.d.title);
      p.j(paramViewGroup, "view.findViewById(R.id.title)");
      this.jMg = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.selected);
      p.j(paramViewGroup, "view.findViewById(R.id.selected)");
      this.rsx = ((ImageView)paramViewGroup);
      AppMethodBeat.o(244536);
    }
    
    public final void c(h.a parama)
    {
      AppMethodBeat.i(244532);
      p.k(parama, "item");
      this.jMg.setText((CharSequence)parama.title);
      AppMethodBeat.o(244532);
    }
    
    public final void ki(boolean paramBoolean)
    {
      AppMethodBeat.i(244534);
      ImageView localImageView = this.rsx;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(244534);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"})
  public static final class f
    extends h.g
  {
    private ImageView bwJ;
    private final TextView jMg;
    private final ViewGroup parent;
    private final ImageView rsx;
    private final TextView rsy;
    
    public f(ViewGroup paramViewGroup, List<h.a> paramList, h paramh)
    {
      super(paramList, paramh);
      AppMethodBeat.i(250674);
      this.parent = paramViewGroup;
      paramViewGroup = this.view.findViewById(a.d.icon);
      p.j(paramViewGroup, "view.findViewById(R.id.icon)");
      this.bwJ = ((ImageView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.title);
      p.j(paramViewGroup, "view.findViewById(R.id.title)");
      this.jMg = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.sub_title);
      p.j(paramViewGroup, "view.findViewById(R.id.sub_title)");
      this.rsy = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(a.d.selected);
      p.j(paramViewGroup, "view.findViewById(R.id.selected)");
      this.rsx = ((ImageView)paramViewGroup);
      AppMethodBeat.o(250674);
    }
    
    public final void c(h.a parama)
    {
      AppMethodBeat.i(250672);
      p.k(parama, "item");
      this.bwJ.setImageResource(a.c.default_avatar);
      TextView localTextView = this.jMg;
      Object localObject = com.tencent.mm.plugin.appbrand.widget.input.a.a.cpy().a(this.jMg.getContext(), (CharSequence)parama.title, this.jMg.getTextSize());
      if (localObject != null)
      {
        localObject = (CharSequence)localObject;
        localTextView.setText((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)parama.rsw)) {
          break label186;
        }
        this.rsy.setVisibility(0);
        localTextView = this.rsy;
        localObject = parama.rsw;
        if (localObject == null) {
          break label177;
        }
        localObject = (CharSequence)localObject;
        label113:
        localTextView.setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (parama.qGu != null)
        {
          parama = BitmapUtil.getRoundedCornerBitmap(parama.qGu, false, com.tencent.mm.ci.a.fromDPToPix(this.view.getContext(), 4) * 1.0F, false);
          if (parama != null)
          {
            this.bwJ.setImageBitmap(parama);
            AppMethodBeat.o(250672);
            return;
            localObject = (CharSequence)"";
            break;
            label177:
            localObject = (CharSequence)"";
            break label113;
            label186:
            this.rsy.setVisibility(8);
            continue;
          }
          this.bwJ.setImageResource(a.c.default_avatar);
          AppMethodBeat.o(250672);
          return;
        }
      }
      if (((CharSequence)parama.iconUrl).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          com.tencent.mm.modelappbrand.a.b.bhh().a(this.bwJ, parama.iconUrl, a.c.default_avatar, (b.h)new h.f.a(this));
        }
        AppMethodBeat.o(250672);
        return;
      }
    }
    
    public final void ki(boolean paramBoolean)
    {
      AppMethodBeat.i(250673);
      ImageView localImageView = this.rsx;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(250673);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getItems", "()Ljava/util/List;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "reanderView", "refreshCheckView", "check", "", "renderViewChecked", "checked", "luggage-wechat-full-sdk_release"})
  public static abstract class g
    extends RecyclerView.v
  {
    final List<h.a> lxh;
    private final h rsA;
    View view;
    
    public g(View paramView, List<h.a> paramList, h paramh)
    {
      super();
      this.view = paramView;
      this.lxh = paramList;
      this.rsA = paramh;
    }
    
    final void a(boolean paramBoolean, h.a parama)
    {
      h.b localb;
      if (this.lxh.size() == 1)
      {
        ki(true);
        if (paramBoolean)
        {
          localb = this.rsA.qcl;
          if (localb != null) {
            localb.a(parama);
          }
        }
        return;
      }
      if (paramBoolean)
      {
        localb = this.rsA.qcl;
        if (localb != null) {
          localb.a(parama);
        }
        ki(true);
        return;
      }
      ki(false);
    }
    
    public abstract void c(h.a parama);
    
    public abstract void ki(boolean paramBoolean);
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class b
      implements View.OnLongClickListener
    {
      b(h.g paramg, h.a parama, int paramInt) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(245318);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        paramView = h.g.a(this.rsB).rsu;
        if (paramView != null) {
          paramView.a(this.rsB.view, this.rsC, this.jEN);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(245318);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h
 * JD-Core Version:    0.7.0.1
 */