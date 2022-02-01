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
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "Lkotlin/collections/ArrayList;", "onItemLongClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "getCount", "", "getItem", "position", "getItemId", "", "getName", "ct", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "interest", "likeUsername", "setLikedContactList", "contacts", "", "LikedViewHolder", "plugin-finder_release"})
public final class c
  extends BaseAdapter
{
  private String TAG;
  private Activity dKq;
  private ArrayList<as> kgc;
  public q<? super View, ? super String, ? super Boolean, x> vKe;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(252380);
    this.TAG = "Finder.FinderFriendBlackListAdapter";
    this.dKq = paramActivity;
    this.kgc = new ArrayList();
    AppMethodBeat.o(252380);
  }
  
  private as Ln(int paramInt)
  {
    AppMethodBeat.i(252376);
    Object localObject = this.kgc.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (as)localObject;
    AppMethodBeat.o(252376);
    return localObject;
  }
  
  public final void avP(String paramString)
  {
    AppMethodBeat.i(252375);
    p.h(paramString, "likeUsername");
    Object localObject = (List)this.kgc;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!p.j(((as)((Iterator)localObject).next()).getUsername(), paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.kgc.remove(i);
        notifyDataSetChanged();
      }
      AppMethodBeat.o(252375);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void ew(List<String> paramList)
  {
    AppMethodBeat.i(252379);
    p.h(paramList, "contacts");
    this.kgc.clear();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(str);
      if (localObject != null) {
        this.kgc.add(localObject);
      } else {
        Log.i(this.TAG, "setLikedContactList, not exist contact: ".concat(String.valueOf(str)));
      }
    }
    AppMethodBeat.o(252379);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(252378);
    int i = this.kgc.size();
    AppMethodBeat.o(252378);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"ResourceType"})
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(252374);
    final z.f localf = new z.f();
    localf.SYG = paramView;
    if ((View)localf.SYG == null)
    {
      localf.SYG = aa.jQ((Context)this.dKq).inflate(2131494203, paramViewGroup, false);
      paramView = new a();
      paramViewGroup = (View)localf.SYG;
      p.g(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = (View)localf.SYG;
    if (paramView == null) {
      p.hyc();
    }
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendBlackListAdapter.LikedViewHolder");
      AppMethodBeat.o(252374);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = ((View)localf.SYG).findViewById(2131300859);
    p.g(paramView, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramView = (ImageView)paramView;
    p.h(paramView, "<set-?>");
    locala.gyr = paramView;
    paramView = ((View)localf.SYG).findViewById(2131300863);
    p.g(paramView, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.pIN = paramView;
    locala.getAvatarIv().setImageResource(2131690042);
    final as localas = Ln(paramInt);
    TextView localTextView = locala.pIN;
    if (localTextView == null) {
      p.btv("nicknameTv");
    }
    Context localContext = (Context)this.dKq;
    if ((localas.arH() != 0) && (!Util.isNullOrNil(localas.arJ())))
    {
      paramView = localas.arJ();
      p.g(paramView, "ct.displayRemark");
    }
    for (;;)
    {
      localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)paramView));
      a.b.c(locala.getAvatarIv(), localas.getUsername());
      ((View)localf.SYG).setOnLongClickListener((View.OnLongClickListener)new b(this, localf, localas));
      ((View)localf.SYG).setOnClickListener((View.OnClickListener)new c(this, localas));
      paramView = (View)localf.SYG;
      AppMethodBeat.o(252374);
      return paramView;
      paramViewGroup = localas.getUsername();
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        paramView = "";
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public static final class a
  {
    public ImageView gyr;
    public TextView pIN;
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(252371);
      ImageView localImageView = this.gyr;
      if (localImageView == null) {
        p.btv("avatarIv");
      }
      AppMethodBeat.o(252371);
      return localImageView;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(c paramc, z.f paramf, as paramas) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(252372);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
      paramView = this.vKf.vKe;
      String str;
      if (paramView != null)
      {
        localObject = (View)localf.SYG;
        str = localas.getUsername();
        p.g(str, "blackUser.username");
        if (localas.ajE() != 1) {
          break label120;
        }
      }
      label120:
      for (boolean bool = true;; bool = false)
      {
        paramView.d(localObject, str, Boolean.valueOf(bool));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(252372);
        return true;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, as paramas) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252373);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.d(localas.getUsername(), (Context)c.a(this.vKf));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */