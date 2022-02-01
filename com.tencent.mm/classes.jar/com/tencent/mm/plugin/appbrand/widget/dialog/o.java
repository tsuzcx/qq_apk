package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.f;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "value", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onListItemLongClickListener", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "OnListItemLongClickListener", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class o
  extends RecyclerView.a<d>
{
  List<a> gQr;
  public c lZF;
  public b lZr;
  
  public o(List<a> paramList)
  {
    AppMethodBeat.i(183095);
    this.gQr = paramList;
    AppMethodBeat.o(183095);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(183093);
    int i = this.gQr.size();
    AppMethodBeat.o(183093);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public boolean hJN;
    String iconUrl;
    public int jEi;
    final String lZG;
    Bitmap lmN;
    final String scope;
    final String title;
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, byte paramByte)
    {
      this(paramString1, paramString2, paramString3, paramBitmap, true, "", 0);
    }
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, String paramString4, int paramInt)
    {
      AppMethodBeat.i(183082);
      this.title = paramString1;
      this.lZG = paramString2;
      this.scope = paramString3;
      this.lmN = paramBitmap;
      this.hJN = paramBoolean;
      this.iconUrl = paramString4;
      this.jEi = paramInt;
      AppMethodBeat.o(183082);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(183084);
      AppMethodBeat.o(183084);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(o.a parama);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, o.a parama, int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends RecyclerView.v
  {
    final TextView fQp;
    final List<o.a> gQr;
    ImageView hg;
    final TextView lZH;
    private final ImageView lZI;
    private final o lZJ;
    View view;
    
    public d(View paramView, List<o.a> paramList, o paramo)
    {
      super();
      AppMethodBeat.i(183089);
      this.view = paramView;
      this.gQr = paramList;
      this.lZJ = paramo;
      paramView = this.view.findViewById(2131300874);
      k.g(paramView, "view.findViewById(R.id.icon)");
      this.hg = ((ImageView)paramView);
      paramView = this.view.findViewById(2131305902);
      k.g(paramView, "view.findViewById(R.id.title)");
      this.fQp = ((TextView)paramView);
      paramView = this.view.findViewById(2131305508);
      k.g(paramView, "view.findViewById(R.id.sub_title)");
      this.lZH = ((TextView)paramView);
      paramView = this.view.findViewById(2131304540);
      k.g(paramView, "view.findViewById(R.id.selected)");
      this.lZI = ((ImageView)paramView);
      AppMethodBeat.o(183089);
    }
    
    final void a(boolean paramBoolean, o.a parama)
    {
      AppMethodBeat.i(183088);
      o.b localb;
      if (this.gQr.size() == 1)
      {
        this.lZI.setVisibility(0);
        if (paramBoolean)
        {
          localb = this.lZJ.lZr;
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
          localb = this.lZJ.lZr;
          if (localb != null) {
            localb.a(parama);
          }
          this.lZI.setVisibility(0);
          AppMethodBeat.o(183088);
          return;
        }
        this.lZI.setVisibility(8);
      }
      AppMethodBeat.o(183088);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.h
    {
      public final String AL()
      {
        return "appbrand_user_avatar";
      }
      
      public final Bitmap F(Bitmap paramBitmap)
      {
        AppMethodBeat.i(183085);
        k.h(paramBitmap, "bitmap");
        paramBitmap = f.a(paramBitmap, false, a.fromDPToPix(this.lZK.view.getContext(), 4) * 1.0F, false);
        k.g(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
        AppMethodBeat.o(183085);
        return paramBitmap;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(o.d paramd, o.a parama, int paramInt, b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(183086);
        this.lZL.hJN = true;
        o.d.a(this.lZK, this.lZL.hJN, this.lZL);
        paramView = new ArrayList();
        Iterator localIterator = ((Iterable)this.lZK.gQr).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          int j = i + 1;
          if (i < 0) {
            j.fvx();
          }
          localObject = (o.a)localObject;
          paramView.add(Integer.valueOf(i));
          if (this.fKG != i)
          {
            if (localObject == null) {
              break label149;
            }
            if (((o.a)localObject).hJN == true)
            {
              ((o.a)localObject).hJN = false;
              paramView.add(Integer.valueOf(this.fKG));
            }
          }
          i = j;
          continue;
          label149:
          i = j;
        }
        this.lZM.aA(paramView);
        AppMethodBeat.o(183086);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class c
      implements View.OnLongClickListener
    {
      c(o.d paramd, o.a parama, int paramInt) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(183087);
        paramView = o.d.a(this.lZK).lZF;
        if (paramView != null) {
          paramView.a(this.lZK.view, this.lZL, this.fKG);
        }
        AppMethodBeat.o(183087);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.o
 * JD-Core Version:    0.7.0.1
 */