package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "ItemType", "OnListItemLongClickListener", "ScopeInfoViewHolder", "UserInfoViewHolder", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class i
  extends RecyclerView.a<g>
{
  public static final c oqY;
  public List<a> iHf;
  public b nbX;
  public d oqX;
  
  static
  {
    AppMethodBeat.i(230261);
    oqY = new c((byte)0);
    AppMethodBeat.o(230261);
  }
  
  public i(List<a> paramList)
  {
    AppMethodBeat.i(230260);
    this.iHf = paramList;
    AppMethodBeat.o(230260);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(230257);
    int i = this.iHf.size();
    AppMethodBeat.o(230257);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(230259);
    a locala = (a)this.iHf.get(paramInt);
    if (locala != null)
    {
      paramInt = locala.type;
      AppMethodBeat.o(230259);
      return paramInt;
    }
    AppMethodBeat.o(230259);
    return 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "", "type", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(ILjava/lang/String;Ljava/lang/String;Z)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "getType", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    String iconUrl;
    public boolean jCx;
    public int lGW;
    Bitmap nEk;
    final String oqZ;
    public final String scope;
    final String title;
    final int type;
    
    public a(int paramInt1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(230243);
      this.type = paramInt1;
      this.title = paramString1;
      this.oqZ = paramString2;
      this.scope = paramString3;
      this.nEk = paramBitmap;
      this.jCx = paramBoolean;
      this.iconUrl = paramString4;
      this.lGW = paramInt2;
      AppMethodBeat.o(230243);
    }
    
    public a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, byte paramByte)
    {
      this(0, paramString1, paramString2, paramString3, paramBitmap, true, "", 0);
    }
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt)
    {
      this(0, paramString1, paramString2, paramString3, null, paramBoolean, paramString4, paramInt);
      AppMethodBeat.i(230245);
      AppMethodBeat.o(230245);
    }
    
    public a(String paramString1, String paramString2, boolean paramBoolean)
    {
      this(1, paramString1, "", paramString2, null, paramBoolean, "", 0);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(i.a parama);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemType;", "", "()V", "ITEM_TYPE_SCOPE_INFO", "", "ITEM_TYPE_USER_INFO", "luggage-wechat-full-sdk_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "index", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface d
  {
    public abstract void a(View paramView, i.a parama, int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ScopeInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"})
  public static final class e
    extends i.g
  {
    private final TextView hbb;
    private final ImageView ora;
    private final ViewGroup parent;
    
    public e(ViewGroup paramViewGroup, List<i.a> paramList, i parami)
    {
      super(paramList, parami);
      AppMethodBeat.i(230248);
      this.parent = paramViewGroup;
      paramViewGroup = this.view.findViewById(2131309195);
      p.g(paramViewGroup, "view.findViewById(R.id.title)");
      this.hbb = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(2131307564);
      p.g(paramViewGroup, "view.findViewById(R.id.selected)");
      this.ora = ((ImageView)paramViewGroup);
      AppMethodBeat.o(230248);
    }
    
    public final void c(i.a parama)
    {
      AppMethodBeat.i(230246);
      p.h(parama, "item");
      this.hbb.setText((CharSequence)parama.title);
      AppMethodBeat.o(230246);
    }
    
    public final void jf(boolean paramBoolean)
    {
      AppMethodBeat.i(230247);
      ImageView localImageView = this.ora;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(230247);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"})
  public static final class f
    extends i.g
  {
    private final TextView hbb;
    private ImageView kc;
    private final ImageView ora;
    private final TextView orb;
    private final ViewGroup parent;
    
    public f(ViewGroup paramViewGroup, List<i.a> paramList, i parami)
    {
      super(paramList, parami);
      AppMethodBeat.i(230252);
      this.parent = paramViewGroup;
      paramViewGroup = this.view.findViewById(2131302468);
      p.g(paramViewGroup, "view.findViewById(R.id.icon)");
      this.kc = ((ImageView)paramViewGroup);
      paramViewGroup = this.view.findViewById(2131309195);
      p.g(paramViewGroup, "view.findViewById(R.id.title)");
      this.hbb = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(2131308717);
      p.g(paramViewGroup, "view.findViewById(R.id.sub_title)");
      this.orb = ((TextView)paramViewGroup);
      paramViewGroup = this.view.findViewById(2131307564);
      p.g(paramViewGroup, "view.findViewById(R.id.selected)");
      this.ora = ((ImageView)paramViewGroup);
      AppMethodBeat.o(230252);
    }
    
    public final void c(i.a parama)
    {
      AppMethodBeat.i(230250);
      p.h(parama, "item");
      this.kc.setImageResource(2131231957);
      TextView localTextView = this.hbb;
      Object localObject = com.tencent.mm.plugin.appbrand.widget.input.a.a.cce().a(this.hbb.getContext(), (CharSequence)parama.title, this.hbb.getTextSize());
      if (localObject != null)
      {
        localObject = (CharSequence)localObject;
        localTextView.setText((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)parama.oqZ)) {
          break label185;
        }
        this.orb.setVisibility(0);
        localTextView = this.orb;
        localObject = parama.oqZ;
        if (localObject == null) {
          break label176;
        }
        localObject = (CharSequence)localObject;
        label112:
        localTextView.setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (parama.nEk != null)
        {
          parama = BitmapUtil.getRoundedCornerBitmap(parama.nEk, false, com.tencent.mm.cb.a.fromDPToPix(this.view.getContext(), 4) * 1.0F, false);
          if (parama != null)
          {
            this.kc.setImageBitmap(parama);
            AppMethodBeat.o(230250);
            return;
            localObject = (CharSequence)"";
            break;
            label176:
            localObject = (CharSequence)"";
            break label112;
            label185:
            this.orb.setVisibility(8);
            continue;
          }
          this.kc.setImageResource(2131231957);
          AppMethodBeat.o(230250);
          return;
        }
      }
      if (((CharSequence)parama.iconUrl).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          com.tencent.mm.modelappbrand.a.b.aXY().a(this.kc, parama.iconUrl, 2131231957, (b.h)new a(this));
        }
        AppMethodBeat.o(230250);
        return;
      }
    }
    
    public final void jf(boolean paramBoolean)
    {
      AppMethodBeat.i(230251);
      ImageView localImageView = this.ora;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        AppMethodBeat.o(230251);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder$reanderView$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.h
    {
      public final Bitmap J(Bitmap paramBitmap)
      {
        AppMethodBeat.i(230249);
        p.h(paramBitmap, "bitmap");
        paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, com.tencent.mm.cb.a.fromDPToPix(this.orc.view.getContext(), 4) * 1.0F, false);
        p.g(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
        AppMethodBeat.o(230249);
        return paramBitmap;
      }
      
      public final String Lb()
      {
        return "appbrand_user_avatar";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getItems", "()Ljava/util/List;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "reanderView", "refreshCheckView", "check", "", "renderViewChecked", "checked", "luggage-wechat-full-sdk_release"})
  public static abstract class g
    extends RecyclerView.v
  {
    final List<i.a> iHf;
    private final i ord;
    View view;
    
    public g(View paramView, List<i.a> paramList, i parami)
    {
      super();
      this.view = paramView;
      this.iHf = paramList;
      this.ord = parami;
    }
    
    final void a(boolean paramBoolean, i.a parama)
    {
      i.b localb;
      if (this.iHf.size() == 1)
      {
        jf(true);
        if (paramBoolean)
        {
          localb = this.ord.nbX;
          if (localb != null) {
            localb.a(parama);
          }
        }
        return;
      }
      if (paramBoolean)
      {
        localb = this.ord.nbX;
        if (localb != null) {
          localb.a(parama);
        }
        jf(true);
        return;
      }
      jf(false);
    }
    
    public abstract void c(i.a parama);
    
    public abstract void jf(boolean paramBoolean);
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(i.g paramg, i.a parama, int paramInt, kotlin.g.a.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(230253);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        this.orf.jCx = true;
        i.g.a(this.ore, this.orf.jCx, this.orf);
        paramView = new ArrayList();
        localObject1 = ((Iterable)this.ore.iHf).iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          int j = i + 1;
          if (i < 0) {
            j.hxH();
          }
          localObject2 = (i.a)localObject2;
          paramView.add(Integer.valueOf(i));
          if (this.gUj != i)
          {
            if (localObject2 == null) {
              break label181;
            }
            if (((i.a)localObject2).jCx == true)
            {
              ((i.a)localObject2).jCx = false;
              paramView.add(Integer.valueOf(this.gUj));
            }
          }
          i = j;
          continue;
          label181:
          i = j;
        }
        this.org.invoke(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230253);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class b
      implements View.OnLongClickListener
    {
      b(i.g paramg, i.a parama, int paramInt) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(230254);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        paramView = i.g.a(this.ore).oqX;
        if (paramView != null) {
          paramView.a(this.ore.view, this.orf, this.gUj);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(230254);
        return true;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "changed", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$onBindViewHolder$1$1"})
  static final class h
    extends q
    implements kotlin.g.a.b<ArrayList<Integer>, x>
  {
    h(i parami, i.g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i
 * JD-Core Version:    0.7.0.1
 */