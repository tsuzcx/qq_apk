package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.openim.api.c;
import com.tencent.mm.openim.api.c.a;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKFGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements af.b
{
  public static final a prH;
  
  static
  {
    AppMethodBeat.i(236043);
    prH = new a((byte)0);
    AppMethodBeat.o(236043);
  }
  
  public final boolean aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(236052);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(236052);
      return false;
    }
    boolean bool = au.bwQ(paramString);
    AppMethodBeat.o(236052);
    return bool;
  }
  
  public final az.b bCe()
  {
    AppMethodBeat.i(236046);
    az.b localb = (az.b)new b();
    AppMethodBeat.o(236046);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKFGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/contact/OpenIMKFGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements az.b
  {
    private static void a(String paramString, final az.b.a parama)
    {
      AppMethodBeat.i(236070);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (au.bwQ(paramString)))
        {
          localObject = (c)h.ax(c.class);
          if (localObject != null) {
            ((c)localObject).a(paramString, (c.a)new a(paramString, parama));
          }
        }
        AppMethodBeat.o(236070);
        return;
      }
    }
    
    public final void Jq(String paramString) {}
    
    public final void Jr(String paramString) {}
    
    public final void a(String paramString1, String paramString2, az.b.a parama)
    {
      AppMethodBeat.i(236081);
      if (paramString1 != null) {
        a(paramString1, parama);
      }
      AppMethodBeat.o(236081);
    }
    
    public final void aZ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(236093);
      a(paramString1, null);
      AppMethodBeat.o(236093);
    }
    
    public final void bCc() {}
    
    public final void j(String paramString1, int paramInt, String paramString2) {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/openim/contact/OpenIMKFGetContactInterceptor$getContactImpl$1$getContact$1", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "onFinish", "", "result", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "onTryFetch", "username", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements c.a
    {
      a(String paramString, az.b.a parama) {}
      
      public final void RF(String paramString) {}
      
      public final void a(j paramj)
      {
        boolean bool2 = true;
        AppMethodBeat.i(236114);
        String str = this.mrr;
        Object localObject;
        if (paramj == null)
        {
          localObject = null;
          if (localObject == null) {
            break label104;
          }
          bool1 = true;
          label27:
          Log.i("MicroMsg.OpenIMKFGetContactInterceptor", "alvinluo getContact username: %s, success: %s", new Object[] { str, Boolean.valueOf(bool1) });
          localObject = parama;
          if (localObject != null)
          {
            str = this.mrr;
            if (paramj != null) {
              break label109;
            }
            paramj = null;
            label73:
            if (paramj == null) {
              break label117;
            }
          }
        }
        label104:
        label109:
        label117:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          ((az.b.a)localObject).getContactCallBack(str, bool1);
          AppMethodBeat.o(236114);
          return;
          localObject = paramj.prp;
          break;
          bool1 = false;
          break label27;
          paramj = paramj.prp;
          break label73;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.a.a
 * JD-Core Version:    0.7.0.1
 */