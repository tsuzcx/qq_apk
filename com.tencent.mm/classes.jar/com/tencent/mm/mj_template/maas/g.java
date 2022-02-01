package com.tencent.mm.mj_template.maas;

import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.instamovie.base.MJError.MaasEC;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/MaasRecommendResult;", "", "mjError", "Lcom/tencent/maas/instamovie/base/MJError;", "(Lcom/tencent/maas/instamovie/base/MJError;)V", "isNetError", "", "()Z", "isSuccess", "getMjError", "()Lcom/tencent/maas/instamovie/base/MJError;", "toString", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final int Ue = 8;
  private final boolean isSuccess;
  private final MJError oaJ;
  public final boolean oaK;
  
  public g(MJError paramMJError)
  {
    AppMethodBeat.i(239743);
    this.oaJ = paramMJError;
    boolean bool1;
    if (this.oaJ == null)
    {
      bool1 = true;
      this.isSuccess = bool1;
      paramMJError = this.oaJ;
      if (paramMJError != null) {
        break label90;
      }
      paramMJError = null;
      label44:
      if (paramMJError != MJError.MaasEC.TimedOut)
      {
        paramMJError = this.oaJ;
        if (paramMJError != null) {
          break label98;
        }
      }
    }
    label90:
    label98:
    for (paramMJError = localObject;; paramMJError = paramMJError.ec)
    {
      bool1 = bool2;
      if (paramMJError == MJError.MaasEC.NetworkFailed) {
        bool1 = true;
      }
      this.oaK = bool1;
      AppMethodBeat.o(239743);
      return;
      bool1 = false;
      break;
      paramMJError = paramMJError.ec;
      break label44;
    }
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(239754);
    StringBuilder localStringBuilder = new StringBuilder("MaasRecommendResult(mjError={");
    Object localObject1 = this.oaJ;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      localObject1 = this.oaJ;
      if (localObject1 != null) {
        break label103;
      }
    }
    label103:
    for (localObject1 = localObject2;; localObject1 = ((MJError)localObject1).message)
    {
      localObject1 = localObject1 + "}, isSuccess=" + this.isSuccess + ", isNetError=" + this.oaK + ')';
      AppMethodBeat.o(239754);
      return localObject1;
      localObject1 = ((MJError)localObject1).ec;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.g
 * JD-Core Version:    0.7.0.1
 */