package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dlz;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w
  implements o
{
  private final String jZJ;
  private p lKQ;
  private final ArrayList<PhoneItem> lKR;
  private final ArrayList<PhoneItem> lKS;
  private boolean lKT;
  final String mAppId;
  private final Context mContext;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.jZJ = paramString2;
    this.lKR = new ArrayList();
    this.lKS = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    k.h(paramPhoneItem, "phoneItem");
    this.lKS.add(paramPhoneItem);
    this.lKR.remove(paramPhoneItem);
    paramPhoneItem = this.lKQ;
    if (paramPhoneItem != null)
    {
      paramPhoneItem.b(this.lKT, (List)this.lKR);
      AppMethodBeat.o(148142);
      return;
    }
    AppMethodBeat.o(148142);
  }
  
  public final void bsp()
  {
    AppMethodBeat.i(148141);
    y localy = z.lLJ.Qu(this.mAppId);
    if (localy != null)
    {
      localObject = z.lLJ.Qu(this.mAppId);
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = Long.valueOf(((y)localObject).lLA);; localObject = null)
    {
      if (localObject == null) {
        k.fOy();
      }
      localy.lLA = (((Long)localObject).longValue() + 1L);
      localObject = u.lKF;
      u.bst().a(this.mContext, this.mAppId, (m)w.a.lKU);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString bsq()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.lKF;
    localObject = u.bst().n(this.mContext, this.mAppId, this.jZJ);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void bsr()
  {
    AppMethodBeat.i(148144);
    if (this.lKS.size() >= 0)
    {
      localObject2 = this.lKS.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.lLJ.Qu(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.lLJ.Qu(this.mAppId);
          if (localObject1 == null) {
            break label133;
          }
        }
        label133:
        for (localObject1 = Long.valueOf(((y)localObject1).lLB);; localObject1 = null)
        {
          if (localObject1 == null) {
            k.fOy();
          }
          localy.lLB = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.dnz, 1).x((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.lKd;
    Object localObject2 = this.lKS;
    if (localObject2 == null) {
      k.fOy();
    }
    ((r)localObject1).E((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.lKQ;
    if (localObject != null)
    {
      localObject = ((p)localObject).getView();
      AppMethodBeat.o(148139);
      return localObject;
    }
    AppMethodBeat.o(148139);
    return null;
  }
  
  public final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.lKR.clear();
    Object localObject = this.lKR;
    r localr = r.lKd;
    ((ArrayList)localObject).addAll((Collection)r.bss());
    localObject = this.lKQ;
    if (localObject != null)
    {
      ((p)localObject).b(paramBoolean, (List)this.lKR);
      AppMethodBeat.o(148140);
      return;
    }
    AppMethodBeat.o(148140);
  }
  
  public final void hk(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.lKT = paramBoolean;
      p localp = this.lKQ;
      if (localp == null) {
        break;
      }
      localp.b(this.lKT, (List)this.lKR);
      AppMethodBeat.o(148143);
      return;
    }
    AppMethodBeat.o(148143);
  }
  
  public final void init()
  {
    AppMethodBeat.i(148138);
    this.lKQ = ((p)new x(this.mContext, (o)this));
    this.lKR.clear();
    ArrayList localArrayList = this.lKR;
    r localr = r.lKd;
    localArrayList.addAll((Collection)r.bss());
    z.lLJ.Qt(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.lLJ.Qs(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<dlz, d.y>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w
 * JD-Core Version:    0.7.0.1
 */