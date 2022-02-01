package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fsk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements o
{
  final String mAppId;
  private final Context mContext;
  private final String rAF;
  private p tHw;
  private final ArrayList<PhoneItem> tHx;
  private final ArrayList<PhoneItem> tHy;
  private boolean tHz;
  
  public w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148147);
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.rAF = paramString2;
    this.tHx = new ArrayList();
    this.tHy = new ArrayList();
    AppMethodBeat.o(148147);
  }
  
  public final void b(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148142);
    s.u(paramPhoneItem, "phoneItem");
    this.tHy.add(paramPhoneItem);
    this.tHx.remove(paramPhoneItem);
    paramPhoneItem = this.tHw;
    if (paramPhoneItem != null) {
      paramPhoneItem.d(this.tHz, (List)this.tHx);
    }
    AppMethodBeat.o(148142);
  }
  
  public final void cHw()
  {
    AppMethodBeat.i(148141);
    y localy = z.tIm.afD(this.mAppId);
    if (localy != null)
    {
      localObject = z.tIm.afD(this.mAppId);
      if (localObject != null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = null;; localObject = Long.valueOf(((y)localObject).tIf))
    {
      s.checkNotNull(localObject);
      localy.tIf = (((Long)localObject).longValue() + 1L);
      localObject = u.tHm;
      u.cHB().a(this.mContext, this.mAppId, (m)w.a.tHA);
      AppMethodBeat.o(148141);
      return;
    }
  }
  
  public final SpannableString cHx()
  {
    AppMethodBeat.i(148145);
    Object localObject = u.tHm;
    localObject = u.cHB().s(this.mContext, this.mAppId, this.rAF);
    AppMethodBeat.o(148145);
    return localObject;
  }
  
  public final void cHy()
  {
    AppMethodBeat.i(148144);
    if (this.tHy.size() >= 0)
    {
      localObject2 = this.tHy.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)((Iterator)localObject2).next();
        y localy = z.tIm.afD(this.mAppId);
        if (localy != null)
        {
          localObject1 = z.tIm.afD(this.mAppId);
          if (localObject1 != null) {
            break label124;
          }
        }
        label124:
        for (localObject1 = null;; localObject1 = Long.valueOf(((y)localObject1).tIg))
        {
          s.checkNotNull(localObject1);
          localy.tIg = (((Long)localObject1).longValue() + 1L);
          new g(this.mAppId, localPhoneItem.hRk, 1).Z((b)new b(this));
          break;
        }
      }
    }
    Object localObject1 = r.tGQ;
    Object localObject2 = this.tHy;
    s.checkNotNull(localObject2);
    ((r)localObject1).P((ArrayList)localObject2);
    AppMethodBeat.o(148144);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(148139);
    Object localObject = this.tHw;
    if (localObject == null)
    {
      AppMethodBeat.o(148139);
      return null;
    }
    localObject = ((p)localObject).getView();
    AppMethodBeat.o(148139);
    return localObject;
  }
  
  public final void init()
  {
    AppMethodBeat.i(148138);
    this.tHw = ((p)new x(this.mContext, (o)this));
    this.tHx.clear();
    ArrayList localArrayList = this.tHx;
    r localr = r.tGQ;
    localArrayList.addAll((Collection)r.cHA());
    z.tIm.afC(this.mAppId);
    AppMethodBeat.o(148138);
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(148140);
    this.tHx.clear();
    Object localObject = this.tHx;
    r localr = r.tGQ;
    ((ArrayList)localObject).addAll((Collection)r.cHA());
    localObject = this.tHw;
    if (localObject != null) {
      ((p)localObject).d(paramBoolean, (List)this.tHx);
    }
    AppMethodBeat.o(148140);
  }
  
  public final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(148143);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.tHz = paramBoolean;
      p localp = this.tHw;
      if (localp != null) {
        localp.d(this.tHz, (List)this.tHx);
      }
      AppMethodBeat.o(148143);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(148146);
    z.tIm.afB(this.mAppId);
    AppMethodBeat.o(148146);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<fsk, ah>
  {
    b(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w
 * JD-Core Version:    0.7.0.1
 */