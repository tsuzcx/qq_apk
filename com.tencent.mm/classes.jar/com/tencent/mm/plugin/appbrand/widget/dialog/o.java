package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.g;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "OnListItemLongClickListener", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class o
  extends RecyclerView.a<d>
{
  public List<a> hJj;
  public b lPO;
  public c ncg;
  
  public o(List<a> paramList)
  {
    AppMethodBeat.i(183095);
    this.hJj = paramList;
    AppMethodBeat.o(183095);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(183093);
    int i = this.hJj.size();
    AppMethodBeat.o(183093);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public boolean iDC;
    String iconUrl;
    public int kzo;
    Bitmap moF;
    final String nch;
    public final String scope;
    final String title;
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, byte paramByte)
    {
      this(paramString1, paramString2, paramString3, paramBitmap, true, "", 0);
    }
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, String paramString4, int paramInt)
    {
      AppMethodBeat.i(183082);
      this.title = paramString1;
      this.nch = paramString2;
      this.scope = paramString3;
      this.moF = paramBitmap;
      this.iDC = paramBoolean;
      this.iconUrl = paramString4;
      this.kzo = paramInt;
      AppMethodBeat.o(183082);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(183084);
      AppMethodBeat.o(183084);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(o.a parama);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, o.a parama, int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends RecyclerView.w
  {
    final TextView gnM;
    final List<o.a> hJj;
    ImageView ka;
    final TextView nci;
    private final ImageView ncj;
    private final o nck;
    View view;
    
    public d(View paramView, List<o.a> paramList, o paramo)
    {
      super();
      AppMethodBeat.i(183089);
      this.view = paramView;
      this.hJj = paramList;
      this.nck = paramo;
      paramView = this.view.findViewById(2131300874);
      p.g(paramView, "view.findViewById(R.id.icon)");
      this.ka = ((ImageView)paramView);
      paramView = this.view.findViewById(2131305902);
      p.g(paramView, "view.findViewById(R.id.title)");
      this.gnM = ((TextView)paramView);
      paramView = this.view.findViewById(2131305508);
      p.g(paramView, "view.findViewById(R.id.sub_title)");
      this.nci = ((TextView)paramView);
      paramView = this.view.findViewById(2131304540);
      p.g(paramView, "view.findViewById(R.id.selected)");
      this.ncj = ((ImageView)paramView);
      AppMethodBeat.o(183089);
    }
    
    final void a(boolean paramBoolean, o.a parama)
    {
      AppMethodBeat.i(183088);
      o.b localb;
      if (this.hJj.size() == 1)
      {
        this.ncj.setVisibility(0);
        if (paramBoolean)
        {
          localb = this.nck.lPO;
          if (localb != null)
          {
            localb.a(parama);
            AppMethodBeat.o(183088);
            return;
          }
          AppMethodBeat.o(183088);
        }
      }
      else
      {
        if (paramBoolean)
        {
          localb = this.nck.lPO;
          if (localb != null) {
            localb.a(parama);
          }
          this.ncj.setVisibility(0);
          AppMethodBeat.o(183088);
          return;
        }
        this.ncj.setVisibility(8);
      }
      AppMethodBeat.o(183088);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.h
    {
      public final String BM()
      {
        return "appbrand_user_avatar";
      }
      
      public final Bitmap F(Bitmap paramBitmap)
      {
        AppMethodBeat.i(183085);
        p.h(paramBitmap, "bitmap");
        paramBitmap = g.a(paramBitmap, false, com.tencent.mm.cc.a.fromDPToPix(this.ncl.view.getContext(), 4) * 1.0F, false);
        p.g(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
        AppMethodBeat.o(183085);
        return paramBitmap;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(o.d paramd, o.a parama, int paramInt, d.g.a.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(183086);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        this.ncm.iDC = true;
        o.d.a(this.ncl, this.ncm.iDC, this.ncm);
        paramView = new ArrayList();
        localObject1 = ((Iterable)this.ncl.hJj).iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          int j = i + 1;
          if (i < 0) {
            j.gfB();
          }
          localObject2 = (o.a)localObject2;
          paramView.add(Integer.valueOf(i));
          if (this.ghM != i)
          {
            if (localObject2 == null) {
              break label181;
            }
            if (((o.a)localObject2).iDC == true)
            {
              ((o.a)localObject2).iDC = false;
              paramView.add(Integer.valueOf(this.ghM));
            }
          }
          i = j;
          continue;
          label181:
          i = j;
        }
        this.ncn.invoke(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183086);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class c
      implements View.OnLongClickListener
    {
      c(o.d paramd, o.a parama, int paramInt) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(183087);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        paramView = o.d.a(this.ncl).ncg;
        if (paramView != null) {
          paramView.a(this.ncl.view, this.ncm, this.ghM);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(183087);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.o
 * JD-Core Version:    0.7.0.1
 */