package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    AppMethodBeat.i(250853);
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.aZ(localIconCompat.mType, 1);
    localIconCompat.mData = parama.k(localIconCompat.mData);
    localIconCompat.KN = parama.b(localIconCompat.KN, 3);
    localIconCompat.KO = parama.aZ(localIconCompat.KO, 4);
    localIconCompat.KP = parama.aZ(localIconCompat.KP, 5);
    localIconCompat.jE = ((ColorStateList)parama.b(localIconCompat.jE, 6));
    localIconCompat.KR = parama.V(localIconCompat.KR);
    localIconCompat.jF = PorterDuff.Mode.valueOf(localIconCompat.KR);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(250853);
      return localIconCompat;
      if (localIconCompat.KN != null)
      {
        localIconCompat.KM = localIconCompat.KN;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(250853);
        throw parama;
        if (localIconCompat.KN != null)
        {
          localIconCompat.KM = localIconCompat.KN;
        }
        else
        {
          localIconCompat.KM = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.KO = 0;
          localIconCompat.KP = localIconCompat.mData.length;
          continue;
          localIconCompat.KM = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          continue;
          localIconCompat.KM = localIconCompat.mData;
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(250854);
    paramIconCompat.KR = paramIconCompat.jF.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      if (-1 != paramIconCompat.mType) {
        parama.aY(paramIconCompat.mType, 1);
      }
      if (paramIconCompat.mData != null) {
        parama.j(paramIconCompat.mData);
      }
      if (paramIconCompat.KN != null) {
        parama.a(paramIconCompat.KN, 3);
      }
      if (paramIconCompat.KO != 0) {
        parama.aY(paramIconCompat.KO, 4);
      }
      if (paramIconCompat.KP != 0) {
        parama.aY(paramIconCompat.KP, 5);
      }
      if (paramIconCompat.jE != null) {
        parama.a(paramIconCompat.jE, 6);
      }
      if (paramIconCompat.KR != null) {
        parama.U(paramIconCompat.KR);
      }
      AppMethodBeat.o(250854);
      return;
      paramIconCompat.KN = ((Parcelable)paramIconCompat.KM);
      continue;
      paramIconCompat.KN = ((Parcelable)paramIconCompat.KM);
      continue;
      paramIconCompat.mData = paramIconCompat.KM.toString().getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((String)paramIconCompat.KM).getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((byte[])paramIconCompat.KM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */