package coil.memory;

import coil.size.PixelSize;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/LimitedFileDescriptorHardwareBitmapService;", "Lcoil/memory/HardwareBitmapService;", "()V", "FILE_DESCRIPTOR_CHECK_INTERVAL", "", "FILE_DESCRIPTOR_LIMIT", "MIN_SIZE_DIMENSION", "TAG", "", "decodesSinceLastFileDescriptorCheck", "fileDescriptorList", "Ljava/io/File;", "hasAvailableFileDescriptors", "", "allowHardware", "size", "Lcoil/size/Size;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class k
  extends g
{
  public static final k coo;
  private static final File cop;
  private static volatile int coq;
  private static volatile boolean cor;
  
  static
  {
    AppMethodBeat.i(188304);
    coo = new k();
    cop = new File("/proc/self/fd");
    cor = true;
    AppMethodBeat.o(188304);
  }
  
  private k()
  {
    super((byte)0);
  }
  
  private final boolean a(coil.util.k paramk)
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(188293);
      int i = coq;
      coq = i + 1;
      if (i >= 50)
      {
        coq = 0;
        String[] arrayOfString2 = cop.list();
        String[] arrayOfString1 = arrayOfString2;
        if (arrayOfString2 == null) {
          arrayOfString1 = new String[0];
        }
        i = arrayOfString1.length;
        if (i < 750) {
          bool = true;
        }
        cor = bool;
        if ((!bool) && (paramk != null) && (paramk.getLevel() <= 5)) {
          s.X("Unable to allocate more hardware bitmaps. Number of used file descriptors: ", Integer.valueOf(i));
        }
      }
      bool = cor;
      AppMethodBeat.o(188293);
      return bool;
    }
    finally {}
  }
  
  public final boolean a(Size paramSize, coil.util.k paramk)
  {
    AppMethodBeat.i(188314);
    s.u(paramSize, "size");
    if (((paramSize instanceof PixelSize)) && ((((PixelSize)paramSize).width < 75) || (((PixelSize)paramSize).height < 75)))
    {
      AppMethodBeat.o(188314);
      return false;
    }
    boolean bool = a(paramk);
    AppMethodBeat.o(188314);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.k
 * JD-Core Version:    0.7.0.1
 */