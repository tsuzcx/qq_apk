package com.tencent.mm.openim.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.api.h.b;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.d.a;
import com.tencent.mm.openim.model.IOpenIMKefuConfirmController;
import com.tencent.mm.openim.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmBaseUIModel;", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "confirmController", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "getConfirmController", "()Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "setConfirmController", "(Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;)V", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "getConfirmData", "()Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "setConfirmData", "(Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;)V", "confirmType", "", "getConfirmType", "()I", "setConfirmType", "(I)V", "getContext", "()Landroid/app/Activity;", "setContext", "finishUI", "", "errCode", "errMsg", "", "onConfirm", "onConfirmCancel", "onConfirmOpFailed", "onConfirmOpSuccess", "onCreate", "onUserCancel", "release", "showConfirmUI", "confirmPageType", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements e
{
  public static final b.a ptW = new b.a((byte)0);
  private Activity hHU;
  private int prq;
  IOpenIMKefuConfirmController ptX;
  private j ptY;
  
  public b(Activity paramActivity)
  {
    this.hHU = paramActivity;
    this.prq = -1;
  }
  
  private final void aa(int paramInt, String paramString)
  {
    Log.d("MicroMsg.OpenIMKefuConfirmBaseUIModel", "alvinluo finishUI errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    IOpenIMKefuConfirmController localIOpenIMKefuConfirmController = this.ptX;
    if (localIOpenIMKefuConfirmController != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_err_code", paramInt);
      localIntent.putExtra("key_result_err_msg", paramString);
      paramString = ah.aiuX;
      localIOpenIMKefuConfirmController.b(paramInt, localIntent);
    }
  }
  
  protected final void C(Activity paramActivity)
  {
    this.hHU = paramActivity;
  }
  
  public void a(int paramInt1, int paramInt2, j paramj)
  {
    s.u(paramj, "confirmData");
    this.prq = paramInt1;
    this.ptY = paramj;
    Object localObject = w.psG;
    if (h.b.xE(paramInt1))
    {
      paramj = paramj.prp;
      if (!(paramj instanceof c)) {
        break label68;
      }
      paramj = (c)paramj;
      localObject = this.ptX;
      if (localObject != null) {
        break label73;
      }
    }
    label68:
    label73:
    for (paramInt1 = -1;; paramInt1 = ((IOpenIMKefuConfirmController)localObject).getScene())
    {
      a.a(paramj, 21, paramInt1, 8);
      return;
      paramj = null;
      break;
    }
  }
  
  public void a(IOpenIMKefuConfirmController paramIOpenIMKefuConfirmController)
  {
    s.u(paramIOpenIMKefuConfirmController, "confirmController");
    Log.i("MicroMsg.OpenIMKefuConfirmBaseUIModel", "alvinluo OpenIMKefuConfirmUIModel onCreate: %s", new Object[] { this });
    this.ptX = paramIOpenIMKefuConfirmController;
  }
  
  public void bSn()
  {
    aa(0, "");
  }
  
  public void bSs()
  {
    Object localObject = w.psG;
    label37:
    IOpenIMKefuConfirmController localIOpenIMKefuConfirmController;
    if (h.b.xE(this.prq))
    {
      localObject = this.ptY;
      if (localObject != null) {
        break label58;
      }
      localObject = null;
      if (!(localObject instanceof c)) {
        break label66;
      }
      localObject = (c)localObject;
      localIOpenIMKefuConfirmController = this.ptX;
      if (localIOpenIMKefuConfirmController != null) {
        break label71;
      }
    }
    label58:
    label66:
    label71:
    for (int i = -1;; i = localIOpenIMKefuConfirmController.getScene())
    {
      a.a((c)localObject, 22, i, 8);
      return;
      localObject = ((j)localObject).prp;
      break;
      localObject = null;
      break label37;
    }
  }
  
  protected final void bSt()
  {
    IOpenIMKefuConfirmController localIOpenIMKefuConfirmController = this.ptX;
    if (localIOpenIMKefuConfirmController != null) {
      localIOpenIMKefuConfirmController.cancel();
    }
  }
  
  public void bSu()
  {
    aa(4, "start conversation failed");
  }
  
  public void bSv()
  {
    aa(3, "user cancel");
  }
  
  protected final Activity getContext()
  {
    return this.hHU;
  }
  
  public void release()
  {
    this.hHU = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.b
 * JD-Core Version:    0.7.0.1
 */