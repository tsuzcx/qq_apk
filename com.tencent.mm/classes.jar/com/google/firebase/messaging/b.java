package com.google.firebase.messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class b
  extends Exception
{
  private final int errorCode;
  
  b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(77217);
    int i;
    if (paramString != null)
    {
      paramString = paramString.toLowerCase(Locale.US);
      i = -1;
    }
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        j = 0;
      }
      break;
    }
    for (;;)
    {
      this.errorCode = j;
      AppMethodBeat.o(77217);
      return;
      if (!paramString.equals("invalid_parameters")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("missing_to")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("messagetoobig")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("service_not_available")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("toomanymessages")) {
        break;
      }
      i = 4;
      break;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.firebase.messaging.b
 * JD-Core Version:    0.7.0.1
 */