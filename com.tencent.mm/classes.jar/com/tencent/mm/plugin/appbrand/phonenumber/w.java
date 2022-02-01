package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ewr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w
  implements o
{
  final String mAppId;
  private final Context mContext;
  private final String oxe;
  private final ArrayList<PhoneItem> qCA;
  private boolean qCB;
  private p qCy;
  private final ArrayList<PhoneItem> qCz;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.oxe = paramString2;
    this.qCz = new ArrayList();
    this.qCA = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    kotlin.g.b.p.k(paramPhoneItem, "phoneItem");
    this.qCA.add(paramPhoneItem);
    this.qCz.remove(paramPhoneItem);
    paramPhoneItem = this.qCy;
    if (paramPhoneItem != null)
    {
      paramPhoneItem.b(this.qCB, (List)this.qCz);
      AppMethodBeat.o(148142);
      return;
    }
    AppMethodBeat.o(148142);
  }
  
  public final void cgA()
  {
    AppMethodBeat.i(148141);
    y localy = z.qDr.amr(this.mAppId);
    if (localy != null)
    {
      localObject = z.qDr.amr(this.mAppId);
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = Long.valueOf(((y)localObject).qDi);; localObject = null)
    {
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localy.qDi = (((Long)localObject).longValue() + 1L);
      localObject = u.qCp;
      u.cgE().a(this.mContext, this.mAppId, (m)w.a.qCC);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString cgB()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.qCp;
    localObject = u.cgE().q(this.mContext, this.mAppId, this.oxe);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void cgC()
  {
    AppMethodBeat.i(148144);
    if (this.qCA.size() >= 0)
    {
      localObject2 = this.qCA.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.qDr.amr(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.qDr.amr(this.mAppId);
          if (localObject1 == null) {
            break label133;
          }
        }
        label133:
        for (localObject1 = Long.valueOf(((y)localObject1).qDj);; localObject1 = null)
        {
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localy.qDj = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.fLC, 1).y((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.qBN;
    Object localObject2 = this.qCA;
    if (localObject2 == null) {
      kotlin.g.b.p.iCn();
    }
    ((r)localObject1).L((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.qCy;
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
    this.qCy = ((p)new x(this.mContext, (o)this));
    this.qCz.clear();
    ArrayList localArrayList = this.qCz;
    r localr = r.qBN;
    localArrayList.addAll((Collection)r.cgD());
    z.qDr.amq(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.qCz.clear();
    Object localObject = this.qCz;
    r localr = r.qBN;
    ((ArrayList)localObject).addAll((Collection)r.cgD());
    localObject = this.qCy;
    if (localObject != null)
    {
      ((p)localObject).b(paramBoolean, (List)this.qCz);
      AppMethodBeat.o(148140);
      return;
    }
    AppMethodBeat.o(148140);
  }
  
  public final void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.qCB = paramBoolean;
      p localp = this.qCy;
      if (localp == null) {
        break;
      }
      localp.b(this.qCB, (List)this.qCz);
      AppMethodBeat.o(148143);
      return;
    }
    AppMethodBeat.o(148143);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.qDr.amp(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
  static final class b
    extends q
    implements b<ewr, kotlin.x>
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