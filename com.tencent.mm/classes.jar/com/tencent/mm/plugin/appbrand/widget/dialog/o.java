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
import com.tencent.mm.cc.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.f;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "value", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onListItemLongClickListener", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "OnListItemLongClickListener", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class o
  extends RecyclerView.a<d>
{
  List<a> hqR;
  public c mBG;
  public b mBs;
  
  public o(List<a> paramList)
  {
    AppMethodBeat.i(183095);
    this.hqR = paramList;
    AppMethodBeat.o(183095);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(183093);
    int i = this.hqR.size();
    AppMethodBeat.o(183093);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    String iconUrl;
    public boolean ikl;
    public int keF;
    Bitmap lOP;
    final String mBH;
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
      this.mBH = paramString2;
      this.scope = paramString3;
      this.lOP = paramBitmap;
      this.ikl = paramBoolean;
      this.iconUrl = paramString4;
      this.keF = paramInt;
      AppMethodBeat.o(183082);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(183084);
      AppMethodBeat.o(183084);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(o.a parama);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, o.a parama, int paramInt);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends RecyclerView.w
  {
    final TextView fUk;
    final List<o.a> hqR;
    ImageView ig;
    final TextView mBI;
    private final ImageView mBJ;
    private final o mBK;
    View view;
    
    public d(View paramView, List<o.a> paramList, o paramo)
    {
      super();
      AppMethodBeat.i(183089);
      this.view = paramView;
      this.hqR = paramList;
      this.mBK = paramo;
      paramView = this.view.findViewById(2131300874);
      k.g(paramView, "view.findViewById(R.id.icon)");
      this.ig = ((ImageView)paramView);
      paramView = this.view.findViewById(2131305902);
      k.g(paramView, "view.findViewById(R.id.title)");
      this.fUk = ((TextView)paramView);
      paramView = this.view.findViewById(2131305508);
      k.g(paramView, "view.findViewById(R.id.sub_title)");
      this.mBI = ((TextView)paramView);
      paramView = this.view.findViewById(2131304540);
      k.g(paramView, "view.findViewById(R.id.selected)");
      this.mBJ = ((ImageView)paramView);
      AppMethodBeat.o(183089);
    }
    
    final void a(boolean paramBoolean, o.a parama)
    {
      AppMethodBeat.i(183088);
      o.b localb;
      if (this.hqR.size() == 1)
      {
        this.mBJ.setVisibility(0);
        if (paramBoolean)
        {
          localb = this.mBK.mBs;
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
          localb = this.mBK.mBs;
          if (localb != null) {
            localb.a(parama);
          }
          this.mBJ.setVisibility(0);
          AppMethodBeat.o(183088);
          return;
        }
        this.mBJ.setVisibility(8);
      }
      AppMethodBeat.o(183088);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.h
    {
      public final String Ap()
      {
        return "appbrand_user_avatar";
      }
      
      public final Bitmap F(Bitmap paramBitmap)
      {
        AppMethodBeat.i(183085);
        k.h(paramBitmap, "bitmap");
        paramBitmap = f.a(paramBitmap, false, a.fromDPToPix(this.mBL.view.getContext(), 4) * 1.0F, false);
        k.g(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
        AppMethodBeat.o(183085);
        return paramBitmap;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(o.d paramd, o.a parama, int paramInt, b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(183086);
        this.mBM.ikl = true;
        o.d.a(this.mBL, this.mBM.ikl, this.mBM);
        paramView = new ArrayList();
        Iterator localIterator = ((Iterable)this.mBL.hqR).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          int j = i + 1;
          if (i < 0) {
            j.fOc();
          }
          localObject = (o.a)localObject;
          paramView.add(Integer.valueOf(i));
          if (this.fOm != i)
          {
            if (localObject == null) {
              break label149;
            }
            if (((o.a)localObject).ikl == true)
            {
              ((o.a)localObject).ikl = false;
              paramView.add(Integer.valueOf(this.fOm));
            }
          }
          i = j;
          continue;
          label149:
          i = j;
        }
        this.mBN.ay(paramView);
        AppMethodBeat.o(183086);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class c
      implements View.OnLongClickListener
    {
      c(o.d paramd, o.a parama, int paramInt) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(183087);
        paramView = o.d.a(this.mBL).mBG;
        if (paramView != null) {
          paramView.a(this.mBL.view, this.mBM, this.fOm);
        }
        AppMethodBeat.o(183087);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.o
 * JD-Core Version:    0.7.0.1
 */