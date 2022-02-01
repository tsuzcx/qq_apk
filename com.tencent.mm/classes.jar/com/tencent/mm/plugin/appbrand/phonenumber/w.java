package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.drq;
import d.g.a.b;
import d.g.a.m;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w
  implements o
{
  private final String kuf;
  final String mAppId;
  private final Context mContext;
  private p mkE;
  private final ArrayList<PhoneItem> mkF;
  private final ArrayList<PhoneItem> mkG;
  private boolean mkH;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.kuf = paramString2;
    this.mkF = new ArrayList();
    this.mkG = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    d.g.b.p.h(paramPhoneItem, "phoneItem");
    this.mkG.add(paramPhoneItem);
    this.mkF.remove(paramPhoneItem);
    paramPhoneItem = this.mkE;
    if (paramPhoneItem != null)
    {
      paramPhoneItem.b(this.mkH, (List)this.mkF);
      AppMethodBeat.o(148142);
      return;
    }
    AppMethodBeat.o(148142);
  }
  
  public final void bwu()
  {
    AppMethodBeat.i(148141);
    y localy = z.mlx.TZ(this.mAppId);
    if (localy != null)
    {
      localObject = z.mlx.TZ(this.mAppId);
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = Long.valueOf(((y)localObject).mlo);; localObject = null)
    {
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      localy.mlo = (((Long)localObject).longValue() + 1L);
      localObject = u.mkv;
      u.bwy().a(this.mContext, this.mAppId, (m)w.a.mkI);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString bwv()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.mkv;
    localObject = u.bwy().o(this.mContext, this.mAppId, this.kuf);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void bww()
  {
    AppMethodBeat.i(148144);
    if (this.mkG.size() >= 0)
    {
      localObject2 = this.mkG.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.mlx.TZ(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.mlx.TZ(this.mAppId);
          if (localObject1 == null) {
            break label133;
          }
        }
        label133:
        for (localObject1 = Long.valueOf(((y)localObject1).mlp);; localObject1 = null)
        {
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          localy.mlp = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.dzn, 1).y((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.mjT;
    Object localObject2 = this.mkG;
    if (localObject2 == null) {
      d.g.b.p.gfZ();
    }
    ((r)localObject1).E((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.mkE;
    if (localObject != null)
    {
      localObject = ((p)localObject).getView();
      AppMethodBeat.o(148139);
      return localObject;
    }
    AppMethodBeat.o(148139);
    return null;
  }
  
  public final void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.mkF.clear();
    Object localObject = this.mkF;
    r localr = r.mjT;
    ((ArrayList)localObject).addAll((Collection)r.bwx());
    localObject = this.mkE;
    if (localObject != null)
    {
      ((p)localObject).b(paramBoolean, (List)this.mkF);
      AppMethodBeat.o(148140);
      return;
    }
    AppMethodBeat.o(148140);
  }
  
  public final void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mkH = paramBoolean;
      p localp = this.mkE;
      if (localp == null) {
        break;
      }
      localp.b(this.mkH, (List)this.mkF);
      AppMethodBeat.o(148143);
      return;
    }
    AppMethodBeat.o(148143);
  }
  
  public final void init()
  {
    AppMethodBeat.i(148138);
    this.mkE = ((p)new x(this.mContext, (o)this));
    this.mkF.clear();
    ArrayList localArrayList = this.mkF;
    r localr = r.mjT;
    localArrayList.addAll((Collection)r.bwx());
    z.mlx.TY(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.mlx.TX(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
  static final class b
    extends q
    implements b<drq, d.z>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w
 * JD-Core Version:    0.7.0.1
 */