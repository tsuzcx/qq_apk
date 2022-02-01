package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgk;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w
  implements o
{
  private final String jzm;
  private p lkY;
  private final ArrayList<PhoneItem> lkZ;
  private final ArrayList<PhoneItem> lla;
  private boolean llb;
  final String mAppId;
  private final Context mContext;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.jzm = paramString2;
    this.lkZ = new ArrayList();
    this.lla = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    k.h(paramPhoneItem, "phoneItem");
    this.lla.add(paramPhoneItem);
    this.lkZ.remove(paramPhoneItem);
    paramPhoneItem = this.lkY;
    if (paramPhoneItem != null)
    {
      paramPhoneItem.b(this.llb, (List)this.lkZ);
      AppMethodBeat.o(148142);
      return;
    }
    AppMethodBeat.o(148142);
  }
  
  public final void blA()
  {
    AppMethodBeat.i(148141);
    y localy = z.llS.Mn(this.mAppId);
    if (localy != null)
    {
      localObject = z.llS.Mn(this.mAppId);
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = Long.valueOf(((y)localObject).llJ);; localObject = null)
    {
      if (localObject == null) {
        k.fvU();
      }
      localy.llJ = (((Long)localObject).longValue() + 1L);
      localObject = u.lkN;
      u.blE().a(this.mContext, this.mAppId, (m)w.a.llc);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString blB()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.lkN;
    localObject = u.blE().n(this.mContext, this.mAppId, this.jzm);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void blC()
  {
    AppMethodBeat.i(148144);
    if (this.lla.size() >= 0)
    {
      localObject2 = this.lla.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.llS.Mn(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.llS.Mn(this.mAppId);
          if (localObject1 == null) {
            break label133;
          }
        }
        label133:
        for (localObject1 = Long.valueOf(((y)localObject1).llK);; localObject1 = null)
        {
          if (localObject1 == null) {
            k.fvU();
          }
          localy.llK = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.dpO, 1).t((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.lkl;
    Object localObject2 = this.lla;
    if (localObject2 == null) {
      k.fvU();
    }
    ((r)localObject1).z((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.lkZ.clear();
    Object localObject = this.lkZ;
    r localr = r.lkl;
    ((ArrayList)localObject).addAll((Collection)r.blD());
    localObject = this.lkY;
    if (localObject != null)
    {
      ((p)localObject).b(paramBoolean, (List)this.lkZ);
      AppMethodBeat.o(148140);
      return;
    }
    AppMethodBeat.o(148140);
  }
  
  public final void gQ(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.llb = paramBoolean;
      p localp = this.lkY;
      if (localp == null) {
        break;
      }
      localp.b(this.llb, (List)this.lkZ);
      AppMethodBeat.o(148143);
      return;
    }
    AppMethodBeat.o(148143);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.lkY;
    if (localObject != null)
    {
      localObject = ((p)localObject).getView();
      AppMethodBeat.o(148139);
      return localObject;
    }
    AppMethodBeat.o(148139);
    return null;
  }
  
  public final void init()
  {
    AppMethodBeat.i(148138);
    this.lkY = ((p)new x(this.mContext, (o)this));
    this.lkZ.clear();
    ArrayList localArrayList = this.lkZ;
    r localr = r.lkl;
    localArrayList.addAll((Collection)r.blD());
    z.llS.Mm(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.llS.Ml(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<dgk, d.y>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w
 * JD-Core Version:    0.7.0.1
 */