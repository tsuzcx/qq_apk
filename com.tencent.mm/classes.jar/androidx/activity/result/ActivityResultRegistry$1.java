package androidx.activity.result;

import android.os.Bundle;
import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

class ActivityResultRegistry$1
  implements o
{
  ActivityResultRegistry$1(c paramc, String paramString, a parama, androidx.activity.result.a.a parama1) {}
  
  public void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(199244);
    if (j.a.ON_START.equals(parama))
    {
      this.fe.eV.put(this.val$key, new c.a(this.eY, this.eZ));
      if (this.fe.eW.containsKey(this.val$key))
      {
        paramq = this.fe.eW.get(this.val$key);
        this.fe.eW.remove(this.val$key);
        this.eY.l(paramq);
      }
      paramq = (ActivityResult)this.fe.eX.getParcelable(this.val$key);
      if (paramq != null)
      {
        this.fe.eX.remove(this.val$key);
        this.eY.l(this.eZ.a(paramq.mResultCode, paramq.eP));
      }
      AppMethodBeat.o(199244);
      return;
    }
    if (j.a.ON_STOP.equals(parama))
    {
      this.fe.eV.remove(this.val$key);
      AppMethodBeat.o(199244);
      return;
    }
    if (j.a.ON_DESTROY.equals(parama)) {
      this.fe.unregister(this.val$key);
    }
    AppMethodBeat.o(199244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry.1
 * JD-Core Version:    0.7.0.1
 */