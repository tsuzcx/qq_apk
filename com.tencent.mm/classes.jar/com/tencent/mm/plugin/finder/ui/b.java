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
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.a.q;
import d.g.b.p;
import d.g.b.y.f;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "Lkotlin/collections/ArrayList;", "onItemLongClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "getCount", "", "getItem", "position", "getItemId", "", "getName", "ct", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "interest", "likeUsername", "setLikedContactList", "contacts", "", "LikedViewHolder", "plugin-finder_release"})
public final class b
  extends BaseAdapter
{
  private String TAG;
  private Activity dsa;
  private ArrayList<am> jfg;
  public q<? super View, ? super String, ? super Boolean, d.z> sCF;
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(203995);
    this.TAG = "Finder.FinderFriendBlackListAdapter";
    this.dsa = paramActivity;
    this.jfg = new ArrayList();
    AppMethodBeat.o(203995);
  }
  
  private am FC(int paramInt)
  {
    AppMethodBeat.i(203991);
    Object localObject = this.jfg.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (am)localObject;
    AppMethodBeat.o(203991);
    return localObject;
  }
  
  public final void aiI(String paramString)
  {
    AppMethodBeat.i(203990);
    p.h(paramString, "likeUsername");
    Object localObject = (List)this.jfg;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!p.i(((am)((Iterator)localObject).next()).getUsername(), paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.jfg.remove(i);
        notifyDataSetChanged();
      }
      AppMethodBeat.o(203990);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void dK(List<String> paramList)
  {
    AppMethodBeat.i(203994);
    p.h(paramList, "contacts");
    this.jfg.clear();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(str);
      if (localObject != null) {
        this.jfg.add(localObject);
      } else {
        ad.i(this.TAG, "setLikedContactList, not exist contact: ".concat(String.valueOf(str)));
      }
    }
    AppMethodBeat.o(203994);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(203993);
    int i = this.jfg.size();
    AppMethodBeat.o(203993);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"ResourceType"})
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203989);
    final y.f localf = new y.f();
    localf.MLV = paramView;
    if ((View)localf.MLV == null)
    {
      localf.MLV = com.tencent.mm.ui.z.jO((Context)this.dsa).inflate(2131496173, paramViewGroup, false);
      paramView = new a();
      paramViewGroup = (View)localf.MLV;
      p.g(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = (View)localf.MLV;
    if (paramView == null) {
      p.gfZ();
    }
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendBlackListAdapter.LikedViewHolder");
      AppMethodBeat.o(203989);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = ((View)localf.MLV).findViewById(2131307402);
    p.g(paramView, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramView = (ImageView)paramView;
    p.h(paramView, "<set-?>");
    locala.fRd = paramView;
    paramView = ((View)localf.MLV).findViewById(2131307406);
    p.g(paramView, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.opA = paramView;
    locala.getAvatarIv().setImageResource(2131690013);
    final am localam = FC(paramInt);
    TextView localTextView = locala.opA;
    if (localTextView == null) {
      p.bcb("nicknameTv");
    }
    Context localContext = (Context)this.dsa;
    if ((localam.adt() != 0) && (!bt.isNullOrNil(localam.adv())))
    {
      paramView = localam.adv();
      p.g(paramView, "ct.displayRemark");
    }
    for (;;)
    {
      localTextView.setText((CharSequence)k.c(localContext, (CharSequence)paramView));
      a.b.c(locala.getAvatarIv(), localam.getUsername());
      ((View)localf.MLV).setOnLongClickListener((View.OnLongClickListener)new b(this, localf, localam));
      ((View)localf.MLV).setOnClickListener((View.OnClickListener)new c(this, localam));
      paramView = (View)localf.MLV;
      AppMethodBeat.o(203989);
      return paramView;
      paramViewGroup = localam.getUsername();
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        paramView = "";
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public static final class a
  {
    public ImageView fRd;
    public TextView opA;
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(203986);
      ImageView localImageView = this.fRd;
      if (localImageView == null) {
        p.bcb("avatarIv");
      }
      AppMethodBeat.o(203986);
      return localImageView;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(b paramb, y.f paramf, am paramam) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(203987);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.sCG.sCF;
      String str;
      if (paramView != null)
      {
        localObject = (View)localf.MLV;
        str = localam.getUsername();
        p.g(str, "blackUser.username");
        if (localam.VI() != 1) {
          break label120;
        }
      }
      label120:
      for (boolean bool = true;; bool = false)
      {
        paramView.d(localObject, str, Boolean.valueOf(bool));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(203987);
        return true;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb, am paramam) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203988);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = localam.getUsername();
      p.g(paramView, "blackUser.username");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)b.a(this.sCG));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203988);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.b
 * JD-Core Version:    0.7.0.1
 */