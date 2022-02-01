package androidx.camera.camera2;

import androidx.camera.core.impl.as;
import androidx.camera.core.impl.av;
import androidx.camera.core.u;
import androidx.camera.core.u.a;
import androidx.camera.core.u.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Camera2Config
{
  public static u fS()
  {
    AppMethodBeat.i(197247);
    Object localObject = Camera2Config..ExternalSyntheticLambda2.INSTANCE;
    Camera2Config..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = Camera2Config..ExternalSyntheticLambda1.INSTANCE;
    Camera2Config..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = Camera2Config..ExternalSyntheticLambda0.INSTANCE;
    u.a locala = new u.a();
    locala.He.c(u.GW, localObject);
    locala.He.c(u.GX, localExternalSyntheticLambda1);
    locala.He.c(u.GY, localExternalSyntheticLambda0);
    localObject = new u(av.l(locala.He));
    AppMethodBeat.o(197247);
    return localObject;
  }
  
  public static final class DefaultProvider
    implements u.b
  {
    public final u getCameraXConfig()
    {
      AppMethodBeat.i(197314);
      u localu = Camera2Config.fS();
      AppMethodBeat.o(197314);
      return localu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.Camera2Config
 * JD-Core Version:    0.7.0.1
 */