package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "Lkotlin/collections/ArrayList;", "onItemLongClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "getCount", "", "getItem", "position", "getItemId", "", "getName", "ct", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "interest", "likeUsername", "setLikedContactList", "contacts", "", "LikedViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends BaseAdapter
{
  public q<? super View, ? super String, ? super Boolean, ah> DQi;
  public String TAG;
  private Activity hHU;
  public ArrayList<au> pUj;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(346577);
    this.TAG = "Finder.FinderFriendBlackListAdapter";
    this.hHU = paramActivity;
    this.pUj = new ArrayList();
    AppMethodBeat.o(346577);
  }
  
  private au TF(int paramInt)
  {
    AppMethodBeat.i(346584);
    Object localObject = this.pUj.get(paramInt);
    s.s(localObject, "dataList[position]");
    localObject = (au)localObject;
    AppMethodBeat.o(346584);
    return localObject;
  }
  
  private static final void a(au paramau, c paramc, View paramView)
  {
    AppMethodBeat.i(346609);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramau);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramau, "$blackUser");
    s.u(paramc, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.e(paramau.field_username, (Context)paramc.hHU);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346609);
  }
  
  private static final boolean a(c paramc, ah.f paramf, au paramau, View paramView)
  {
    AppMethodBeat.i(346597);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramf);
    localb.cH(paramau);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.u(paramf, "$itemView");
    s.u(paramau, "$blackUser");
    paramc = paramc.DQi;
    if (paramc != null)
    {
      paramf = paramf.aqH;
      paramView = paramau.field_username;
      s.s(paramView, "blackUser.username");
      if (paramau.sex != 1) {
        break label159;
      }
    }
    label159:
    for (boolean bool = true;; bool = false)
    {
      paramc.invoke(paramf, paramView, Boolean.valueOf(bool));
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(346597);
      return true;
    }
  }
  
  public final void aBa(String paramString)
  {
    AppMethodBeat.i(346643);
    s.u(paramString, "likeUsername");
    Object localObject = (List)this.pUj;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!s.p(((au)((Iterator)localObject).next()).field_username, paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.pUj.remove(i);
        notifyDataSetChanged();
      }
      AppMethodBeat.o(346643);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(346656);
    int i = this.pUj.size();
    AppMethodBeat.o(346656);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(346637);
    ah.f localf = new ah.f();
    localf.aqH = paramView;
    if (localf.aqH == null)
    {
      localf.aqH = af.mU((Context)this.hHU).inflate(e.f.finder_black_list_item_layout, paramViewGroup, false);
      paramView = new a();
      ((View)localf.aqH).setTag(paramView);
    }
    paramView = localf.aqH;
    s.checkNotNull(paramView);
    paramView = ((View)paramView).getTag();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendBlackListAdapter.LikedViewHolder");
      AppMethodBeat.o(346637);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = ((View)localf.aqH).findViewById(e.e.finder_liked_avatar_iv);
    s.s(paramView, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramView = (ImageView)paramView;
    s.u(paramView, "<set-?>");
    locala.lKK = paramView;
    paramView = ((View)localf.aqH).findViewById(e.e.finder_liked_username_tv);
    s.s(paramView, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramView = (TextView)paramView;
    s.u(paramView, "<set-?>");
    locala.nicknameTv = paramView;
    locala.getAvatarIv().setImageResource(e.g.default_avatar);
    au localau = TF(paramInt);
    paramViewGroup = locala.nicknameTv;
    Context localContext;
    if (paramViewGroup != null)
    {
      localContext = (Context)this.hHU;
      if (((int)localau.maN == 0) || (Util.isNullOrNil(localau.aSV()))) {
        break label367;
      }
      paramView = localau.aSV();
      s.s(paramView, "ct.displayRemark");
    }
    for (;;)
    {
      paramViewGroup.setText((CharSequence)p.b(localContext, (CharSequence)paramView));
      a.b.g(locala.getAvatarIv(), localau.field_username);
      ((View)localf.aqH).setOnLongClickListener(new c..ExternalSyntheticLambda1(this, localf, localau));
      ((View)localf.aqH).setOnClickListener(new c..ExternalSyntheticLambda0(localau, this));
      paramView = (View)localf.aqH;
      AppMethodBeat.o(346637);
      return paramView;
      s.bIx("nicknameTv");
      paramViewGroup = null;
      break;
      label367:
      String str = localau.field_username;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public ImageView lKK;
    public TextView nicknameTv;
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(347784);
      ImageView localImageView = this.lKK;
      if (localImageView != null)
      {
        AppMethodBeat.o(347784);
        return localImageView;
      }
      s.bIx("avatarIv");
      AppMethodBeat.o(347784);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */