package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public class a
{
  private static final Pattern bCm;
  private static a bCn;
  public final FirebaseInstanceId bBu;
  
  static
  {
    AppMethodBeat.i(116779);
    bCm = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    AppMethodBeat.o(116779);
  }
  
  private a(FirebaseInstanceId paramFirebaseInstanceId)
  {
    this.bBu = paramFirebaseInstanceId;
  }
  
  public static a wU()
  {
    try
    {
      AppMethodBeat.i(116778);
      if (bCn == null) {
        bCn = new a(FirebaseInstanceId.wx());
      }
      a locala = bCn;
      AppMethodBeat.o(116778);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.messaging.a
 * JD-Core Version:    0.7.0.1
 */