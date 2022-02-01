package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dsn;
import d.g.a.b;
import d.g.a.m;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w
  implements o
{
  private final String kxv;
  final String mAppId;
  private final Context mContext;
  private p mpB;
  private final ArrayList<PhoneItem> mpC;
  private final ArrayList<PhoneItem> mpD;
  private boolean mpE;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.kxv = paramString2;
    this.mpC = new ArrayList();
    this.mpD = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    d.g.b.p.h(paramPhoneItem, "phoneItem");
    this.mpD.add(paramPhoneItem);
    this.mpC.remove(paramPhoneItem);
    paramPhoneItem = this.mpB;
    if (paramPhoneItem != null)
    {
      paramPhoneItem.b(this.mpE, (List)this.mpC);
      AppMethodBeat.o(148142);
      return;
    }
    AppMethodBeat.o(148142);
  }
  
  public final void bxl()
  {
    AppMethodBeat.i(148141);
    y localy = z.mqu.UJ(this.mAppId);
    if (localy != null)
    {
      localObject = z.mqu.UJ(this.mAppId);
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = Long.valueOf(((y)localObject).mql);; localObject = null)
    {
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localy.mql = (((Long)localObject).longValue() + 1L);
      localObject = u.mps;
      u.bxp().a(this.mContext, this.mAppId, (m)w.a.mpF);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString bxm()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.mps;
    localObject = u.bxp().o(this.mContext, this.mAppId, this.kxv);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void bxn()
  {
    AppMethodBeat.i(148144);
    if (this.mpD.size() >= 0)
    {
      localObject2 = this.mpD.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.mqu.UJ(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.mqu.UJ(this.mAppId);
          if (localObject1 == null) {
            break label133;
          }
        }
        label133:
        for (localObject1 = Long.valueOf(((y)localObject1).mqm);; localObject1 = null)
        {
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          localy.mqm = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.dAs, 1).y((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.moQ;
    Object localObject2 = this.mpD;
    if (localObject2 == null) {
      d.g.b.p.gkB();
    }
    ((r)localObject1).E((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.mpB;
    if (localObject != null)
    {
      localObject = ((p)localObject).getView();
      AppMethodBeat.o(148139);
      return localObject;
    }
    AppMethodBeat.o(148139);
    return null;
  }
  
  public final void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.mpC.clear();
    Object localObject = this.mpC;
    r localr = r.moQ;
    ((ArrayList)localObject).addAll((Collection)r.bxo());
    localObject = this.mpB;
    if (localObject != null)
    {
      ((p)localObject).b(paramBoolean, (List)this.mpC);
      AppMethodBeat.o(148140);
      return;
    }
    AppMethodBeat.o(148140);
  }
  
  public final void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mpE = paramBoolean;
      p localp = this.mpB;
      if (localp == null) {
        break;
      }
      localp.b(this.mpE, (List)this.mpC);
      AppMethodBeat.o(148143);
      return;
    }
    AppMethodBeat.o(148143);
  }
  
  public final void init()
  {
    AppMethodBeat.i(148138);
    this.mpB = ((p)new x(this.mContext, (o)this));
    this.mpC.clear();
    ArrayList localArrayList = this.mpC;
    r localr = r.moQ;
    localArrayList.addAll((Collection)r.bxo());
    z.mqu.UI(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.mqu.UH(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
  static final class b
    extends q
    implements b<dsn, d.z>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w
 * JD-Core Version:    0.7.0.1
 */