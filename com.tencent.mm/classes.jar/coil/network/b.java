package coil.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import okhttp3.z;

@Metadata(d1={""}, d2={"Lcoil/network/HttpException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "getResponse", "()Lokhttp3/Response;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RuntimeException
{
  private final z coS;
  
  public b(z paramz)
  {
    super("HTTP " + paramz.code + ": " + paramz.message);
    AppMethodBeat.i(187782);
    this.coS = paramz;
    AppMethodBeat.o(187782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.network.b
 * JD-Core Version:    0.7.0.1
 */