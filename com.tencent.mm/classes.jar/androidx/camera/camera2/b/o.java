package androidx.camera.camera2.b;

import androidx.camera.core.impl.bd;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class o
{
  private final aa BS;
  private final List<bd> BT;
  volatile boolean BU;
  
  public o(aa paramaa, List<bd> paramList)
  {
    AppMethodBeat.i(197904);
    this.BU = false;
    if (paramaa.Co == aa.a.Cy) {
      bool = true;
    }
    f.checkArgument(bool, "CaptureSession state must be OPENED. Current state:" + paramaa.Co);
    this.BS = paramaa;
    this.BT = Collections.unmodifiableList(new ArrayList(paramList));
    AppMethodBeat.o(197904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.o
 * JD-Core Version:    0.7.0.1
 */