package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public class a
{
  private static final Pattern bKv;
  private static a bKw;
  public final FirebaseInstanceId bJD;
  
  static
  {
    AppMethodBeat.i(116779);
    bKv = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    AppMethodBeat.o(116779);
  }
  
  private a(FirebaseInstanceId paramFirebaseInstanceId)
  {
    this.bJD = paramFirebaseInstanceId;
  }
  
  public static a yT()
  {
    try
    {
      AppMethodBeat.i(116778);
      if (bKw == null) {
        bKw = new a(FirebaseInstanceId.yw());
      }
      a locala = bKw;
      AppMethodBeat.o(116778);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.messaging.a
 * JD-Core Version:    0.7.0.1
 */