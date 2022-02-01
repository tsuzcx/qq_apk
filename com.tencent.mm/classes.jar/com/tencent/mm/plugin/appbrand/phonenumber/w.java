package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eml;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w
  implements o
{
  private final String lBI;
  final String mAppId;
  private final Context mContext;
  private p nAn;
  private final ArrayList<PhoneItem> nAo;
  private final ArrayList<PhoneItem> nAp;
  private boolean nAq;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.lBI = paramString2;
    this.nAo = new ArrayList();
    this.nAp = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    kotlin.g.b.p.h(paramPhoneItem, "phoneItem");
    this.nAp.add(paramPhoneItem);
    this.nAo.remove(paramPhoneItem);
    paramPhoneItem = this.nAn;
    if (paramPhoneItem != null)
    {
      paramPhoneItem.b(this.nAq, (List)this.nAo);
      AppMethodBeat.o(148142);
      return;
    }
    AppMethodBeat.o(148142);
  }
  
  public final void bTv()
  {
    AppMethodBeat.i(148141);
    y localy = z.nBg.aex(this.mAppId);
    if (localy != null)
    {
      localObject = z.nBg.aex(this.mAppId);
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (Object localObject = Long.valueOf(((y)localObject).nAX);; localObject = null)
    {
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      localy.nAX = (((Long)localObject).longValue() + 1L);
      localObject = u.nAe;
      u.bTz().a(this.mContext, this.mAppId, (m)w.a.nAr);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString bTw()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.nAe;
    localObject = u.bTz().n(this.mContext, this.mAppId, this.lBI);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void bTx()
  {
    AppMethodBeat.i(148144);
    if (this.nAp.size() >= 0)
    {
      localObject2 = this.nAp.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.nBg.aex(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.nBg.aex(this.mAppId);
          if (localObject1 == null) {
            break label133;
          }
        }
        label133:
        for (localObject1 = Long.valueOf(((y)localObject1).nAY);; localObject1 = null)
        {
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          localy.nAY = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.dSf, 1).y((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.nzC;
    Object localObject2 = this.nAp;
    if (localObject2 == null) {
      kotlin.g.b.p.hyc();
    }
    ((r)localObject1).K((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.nAn;
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
    this.nAn = ((p)new x(this.mContext, (o)this));
    this.nAo.clear();
    ArrayList localArrayList = this.nAo;
    r localr = r.nzC;
    localArrayList.addAll((Collection)r.bTy());
    z.nBg.aew(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void is(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.nAo.clear();
    Object localObject = this.nAo;
    r localr = r.nzC;
    ((ArrayList)localObject).addAll((Collection)r.bTy());
    localObject = this.nAn;
    if (localObject != null)
    {
      ((p)localObject).b(paramBoolean, (List)this.nAo);
      AppMethodBeat.o(148140);
      return;
    }
    AppMethodBeat.o(148140);
  }
  
  public final void it(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.nAq = paramBoolean;
      p localp = this.nAn;
      if (localp == null) {
        break;
      }
      localp.b(this.nAq, (List)this.nAo);
      AppMethodBeat.o(148143);
      return;
    }
    AppMethodBeat.o(148143);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.nBg.aev(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
  static final class b
    extends q
    implements b<eml, kotlin.x>
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