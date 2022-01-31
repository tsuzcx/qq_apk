package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public class a
{
  private static final Pattern bgF;
  private static a bgG;
  public final FirebaseInstanceId bfN;
  
  static
  {
    AppMethodBeat.i(77208);
    bgF = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    AppMethodBeat.o(77208);
  }
  
  private a(FirebaseInstanceId paramFirebaseInstanceId)
  {
    this.bfN = paramFirebaseInstanceId;
  }
  
  public static a si()
  {
    try
    {
      AppMethodBeat.i(77207);
      if (bgG == null) {
        bgG = new a(FirebaseInstanceId.rL());
      }
      a locala = bgG;
      AppMethodBeat.o(77207);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.messaging.a
 * JD-Core Version:    0.7.0.1
 */