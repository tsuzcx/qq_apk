package coil.i;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/map/ResourceIntMapper;", "Lcoil/map/Mapper;", "", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handles", "", "data", "map", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements b<Integer, Uri>
{
  private final Context context;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(188379);
    this.context = paramContext;
    AppMethodBeat.o(188379);
  }
  
  private boolean gR(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(188388);
    try
    {
      String str = this.context.getResources().getResourceEntryName(paramInt);
      if (str != null) {
        bool = true;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label25:
      break label25;
    }
    AppMethodBeat.o(188388);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.i.c
 * JD-Core Version:    0.7.0.1
 */