package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "OnListItemLongClickListener", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class o
  extends RecyclerView.a<d>
{
  public List<a> hMc;
  public b lUp;
  public c nhp;
  
  public o(List<a> paramList)
  {
    AppMethodBeat.i(183095);
    this.hMc = paramList;
    AppMethodBeat.o(183095);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(183093);
    int i = this.hMc.size();
    AppMethodBeat.o(183093);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public boolean iGv;
    String iconUrl;
    public int kCD;
    Bitmap mtC;
    final String nhq;
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
      this.nhq = paramString2;
      this.scope = paramString3;
      this.mtC = paramBitmap;
      this.iGv = paramBoolean;
      this.iconUrl = paramString4;
      this.kCD = paramInt;
      AppMethodBeat.o(183082);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(183084);
      AppMethodBeat.o(183084);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(o.a parama);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, o.a parama, int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends RecyclerView.w
  {
    final TextView gqi;
    final List<o.a> hMc;
    ImageView ka;
    final TextView nhr;
    private final ImageView nhs;
    private final o nht;
    View view;
    
    public d(View paramView, List<o.a> paramList, o paramo)
    {
      super();
      AppMethodBeat.i(183089);
      this.view = paramView;
      this.hMc = paramList;
      this.nht = paramo;
      paramView = this.view.findViewById(2131300874);
      p.g(paramView, "view.findViewById(R.id.icon)");
      this.ka = ((ImageView)paramView);
      paramView = this.view.findViewById(2131305902);
      p.g(paramView, "view.findViewById(R.id.title)");
      this.gqi = ((TextView)paramView);
      paramView = this.view.findViewById(2131305508);
      p.g(paramView, "view.findViewById(R.id.sub_title)");
      this.nhr = ((TextView)paramView);
      paramView = this.view.findViewById(2131304540);
      p.g(paramView, "view.findViewById(R.id.selected)");
      this.nhs = ((ImageView)paramView);
      AppMethodBeat.o(183089);
    }
    
    final void a(boolean paramBoolean, o.a parama)
    {
      AppMethodBeat.i(183088);
      o.b localb;
      if (this.hMc.size() == 1)
      {
        this.nhs.setVisibility(0);
        if (paramBoolean)
        {
          localb = this.nht.lUp;
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
          localb = this.nht.lUp;
          if (localb != null) {
            localb.a(parama);
          }
          this.nhs.setVisibility(0);
          AppMethodBeat.o(183088);
          return;
        }
        this.nhs.setVisibility(8);
      }
      AppMethodBeat.o(183088);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class c
      implements View.OnLongClickListener
    {
      c(o.d paramd, o.a parama, int paramInt) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(183087);
        b localb = new b();
        localb.bd(paramView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        paramView = o.d.a(this.nhu).nhp;
        if (paramView != null) {
          paramView.a(this.nhu.view, this.nhv, this.gke);
        }
        a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(183087);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.o
 * JD-Core Version:    0.7.0.1
 */