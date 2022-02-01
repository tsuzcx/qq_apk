package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "Lkotlin/collections/ArrayList;", "onItemLongClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "getCount", "", "getItem", "position", "getItemId", "", "getName", "ct", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "interest", "likeUsername", "setLikedContactList", "contacts", "", "LikedViewHolder", "plugin-finder_release"})
public final class c
  extends BaseAdapter
{
  public q<? super View, ? super String, ? super Boolean, x> AqW;
  private String TAG;
  private Activity fDf;
  private ArrayList<as> mXB;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(286529);
    this.TAG = "Finder.FinderFriendBlackListAdapter";
    this.fDf = paramActivity;
    this.mXB = new ArrayList();
    AppMethodBeat.o(286529);
  }
  
  private as Qx(int paramInt)
  {
    AppMethodBeat.i(286525);
    Object localObject = this.mXB.get(paramInt);
    p.j(localObject, "dataList[position]");
    localObject = (as)localObject;
    AppMethodBeat.o(286525);
    return localObject;
  }
  
  public final void aFg(String paramString)
  {
    AppMethodBeat.i(286524);
    p.k(paramString, "likeUsername");
    Object localObject = (List)this.mXB;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!p.h(((as)((Iterator)localObject).next()).getUsername(), paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.mXB.remove(i);
        notifyDataSetChanged();
      }
      AppMethodBeat.o(286524);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void eR(List<String> paramList)
  {
    AppMethodBeat.i(286528);
    p.k(paramList, "contacts");
    this.mXB.clear();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject = h.ae(n.class);
      p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((n)localObject).bbL().RG(str);
      if (localObject != null) {
        this.mXB.add(localObject);
      } else {
        Log.i(this.TAG, "setLikedContactList, not exist contact: ".concat(String.valueOf(str)));
      }
    }
    AppMethodBeat.o(286528);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(286527);
    int i = this.mXB.size();
    AppMethodBeat.o(286527);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"ResourceType"})
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(286523);
    aa.f localf = new aa.f();
    localf.aaBC = paramView;
    if ((View)localf.aaBC == null)
    {
      localf.aaBC = ad.kS((Context)this.fDf).inflate(b.g.finder_black_list_item_layout, paramViewGroup, false);
      paramView = new a();
      paramViewGroup = (View)localf.aaBC;
      p.j(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = (View)localf.aaBC;
    if (paramView == null) {
      p.iCn();
    }
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendBlackListAdapter.LikedViewHolder");
      AppMethodBeat.o(286523);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = ((View)localf.aaBC).findViewById(b.f.finder_liked_avatar_iv);
    p.j(paramView, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramView = (ImageView)paramView;
    p.k(paramView, "<set-?>");
    locala.jiu = paramView;
    paramView = ((View)localf.aaBC).findViewById(b.f.finder_liked_username_tv);
    p.j(paramView, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramView = (TextView)paramView;
    p.k(paramView, "<set-?>");
    locala.xoK = paramView;
    locala.getAvatarIv().setImageResource(b.i.default_avatar);
    final as localas = Qx(paramInt);
    TextView localTextView = locala.xoK;
    if (localTextView == null) {
      p.bGy("nicknameTv");
    }
    Context localContext = (Context)this.fDf;
    if ((localas.ayq() != 0) && (!Util.isNullOrNil(localas.ays())))
    {
      paramView = localas.ays();
      p.j(paramView, "ct.displayRemark");
    }
    for (;;)
    {
      localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)paramView));
      a.b.c(locala.getAvatarIv(), localas.getUsername());
      ((View)localf.aaBC).setOnLongClickListener((View.OnLongClickListener)new c.b(this, localf, localas));
      ((View)localf.aaBC).setOnClickListener((View.OnClickListener)new c(this, localas));
      paramView = (View)localf.aaBC;
      AppMethodBeat.o(286523);
      return paramView;
      paramViewGroup = localas.getUsername();
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        paramView = "";
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public static final class a
  {
    public ImageView jiu;
    public TextView xoK;
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(288282);
      ImageView localImageView = this.jiu;
      if (localImageView == null) {
        p.bGy("avatarIv");
      }
      AppMethodBeat.o(288282);
      return localImageView;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, as paramas) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278894);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.e(localas.getUsername(), (Context)c.a(this.AqX));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */