package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class k
  extends IOException
{
  public q CrM = null;
  
  public k(String paramString)
  {
    super(paramString);
  }
  
  static k emN()
  {
    AppMethodBeat.i(121531);
    k localk = new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(121531);
    return localk;
  }
  
  static k emO()
  {
    AppMethodBeat.i(121532);
    k localk = new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(121532);
    return localk;
  }
  
  static k emP()
  {
    AppMethodBeat.i(121533);
    k localk = new k("CodedInputStream encountered a malformed varint.");
    AppMethodBeat.o(121533);
    return localk;
  }
  
  static k emQ()
  {
    AppMethodBeat.i(121534);
    k localk = new k("Protocol message contained an invalid tag (zero).");
    AppMethodBeat.o(121534);
    return localk;
  }
  
  static k emR()
  {
    AppMethodBeat.i(121535);
    k localk = new k("Protocol message end-group tag did not match expected tag.");
    AppMethodBeat.o(121535);
    return localk;
  }
  
  static k emS()
  {
    AppMethodBeat.i(121536);
    k localk = new k("Protocol message tag had invalid wire type.");
    AppMethodBeat.o(121536);
    return localk;
  }
  
  static k emT()
  {
    AppMethodBeat.i(121537);
    k localk = new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    AppMethodBeat.o(121537);
    return localk;
  }
  
  static k emU()
  {
    AppMethodBeat.i(121538);
    k localk = new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    AppMethodBeat.o(121538);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.g.k
 * JD-Core Version:    0.7.0.1
 */