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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.a.q;
import d.g.b.p;
import d.g.b.y.f;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "Lkotlin/collections/ArrayList;", "onItemLongClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "getCount", "", "getItem", "position", "getItemId", "", "getName", "ct", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "interest", "likeUsername", "setLikedContactList", "contacts", "", "LikedViewHolder", "plugin-finder_release"})
public final class b
  extends BaseAdapter
{
  private String TAG;
  private Activity dtg;
  private ArrayList<an> jhZ;
  public q<? super View, ? super String, ? super Boolean, d.z> sNE;
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(204591);
    this.TAG = "Finder.FinderFriendBlackListAdapter";
    this.dtg = paramActivity;
    this.jhZ = new ArrayList();
    AppMethodBeat.o(204591);
  }
  
  private an Ga(int paramInt)
  {
    AppMethodBeat.i(204587);
    Object localObject = this.jhZ.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (an)localObject;
    AppMethodBeat.o(204587);
    return localObject;
  }
  
  public final void ajF(String paramString)
  {
    AppMethodBeat.i(204586);
    p.h(paramString, "likeUsername");
    Object localObject = (List)this.jhZ;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!p.i(((an)((Iterator)localObject).next()).getUsername(), paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.jhZ.remove(i);
        notifyDataSetChanged();
      }
      AppMethodBeat.o(204586);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void dN(List<String> paramList)
  {
    AppMethodBeat.i(204590);
    p.h(paramList, "contacts");
    this.jhZ.clear();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(str);
      if (localObject != null) {
        this.jhZ.add(localObject);
      } else {
        ae.i(this.TAG, "setLikedContactList, not exist contact: ".concat(String.valueOf(str)));
      }
    }
    AppMethodBeat.o(204590);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(204589);
    int i = this.jhZ.size();
    AppMethodBeat.o(204589);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"ResourceType"})
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204585);
    final y.f localf = new y.f();
    localf.NiY = paramView;
    if ((View)localf.NiY == null)
    {
      localf.NiY = com.tencent.mm.ui.z.jV((Context)this.dtg).inflate(2131496173, paramViewGroup, false);
      paramView = new a();
      paramViewGroup = (View)localf.NiY;
      p.g(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = (View)localf.NiY;
    if (paramView == null) {
      p.gkB();
    }
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendBlackListAdapter.LikedViewHolder");
      AppMethodBeat.o(204585);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = ((View)localf.NiY).findViewById(2131307402);
    p.g(paramView, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramView = (ImageView)paramView;
    p.h(paramView, "<set-?>");
    locala.fTj = paramView;
    paramView = ((View)localf.NiY).findViewById(2131307406);
    p.g(paramView, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.ovs = paramView;
    locala.getAvatarIv().setImageResource(2131690013);
    final an localan = Ga(paramInt);
    TextView localTextView = locala.ovs;
    if (localTextView == null) {
      p.bdF("nicknameTv");
    }
    Context localContext = (Context)this.dtg;
    if ((localan.adE() != 0) && (!bu.isNullOrNil(localan.adG())))
    {
      paramView = localan.adG();
      p.g(paramView, "ct.displayRemark");
    }
    for (;;)
    {
      localTextView.setText((CharSequence)k.c(localContext, (CharSequence)paramView));
      a.b.c(locala.getAvatarIv(), localan.getUsername());
      ((View)localf.NiY).setOnLongClickListener((View.OnLongClickListener)new b(this, localf, localan));
      ((View)localf.NiY).setOnClickListener((View.OnClickListener)new c(this, localan));
      paramView = (View)localf.NiY;
      AppMethodBeat.o(204585);
      return paramView;
      paramViewGroup = localan.getUsername();
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        paramView = "";
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public static final class a
  {
    public ImageView fTj;
    public TextView ovs;
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(204582);
      ImageView localImageView = this.fTj;
      if (localImageView == null) {
        p.bdF("avatarIv");
      }
      AppMethodBeat.o(204582);
      return localImageView;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(b paramb, y.f paramf, an paraman) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(204583);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = this.sNF.sNE;
      String str;
      if (paramView != null)
      {
        localObject = (View)localf.NiY;
        str = localan.getUsername();
        p.g(str, "blackUser.username");
        if (localan.VQ() != 1) {
          break label120;
        }
      }
      label120:
      for (boolean bool = true;; bool = false)
      {
        paramView.d(localObject, str, Boolean.valueOf(bool));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(204583);
        return true;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb, an paraman) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204584);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.d(localan.getUsername(), (Context)b.a(this.sNF));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.b
 * JD-Core Version:    0.7.0.1
 */