package androidx.camera.camera2.b.a.c;

import android.util.Size;
import androidx.camera.camera2.b.a.b.h;
import androidx.camera.camera2.b.a.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  private final String AW;
  
  public d(String paramString)
  {
    this.AW = paramString;
  }
  
  public final List<Size> aR(int paramInt)
  {
    AppMethodBeat.i(198182);
    if ((i)h.f(i.class) == null)
    {
      localObject = new ArrayList();
      AppMethodBeat.o(198182);
      return localObject;
    }
    Object localObject = i.g(this.AW, paramInt);
    AppMethodBeat.o(198182);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */