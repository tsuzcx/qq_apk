package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioAttributesCompat
  implements c
{
  private static final SparseIntArray bJp;
  private static final int[] bJq;
  AudioAttributesImpl bJr;
  
  static
  {
    AppMethodBeat.i(193033);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    bJp = localSparseIntArray;
    localSparseIntArray.put(5, 1);
    bJp.put(6, 2);
    bJp.put(7, 2);
    bJp.put(8, 1);
    bJp.put(9, 1);
    bJp.put(10, 1);
    bJq = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16 };
    AppMethodBeat.o(193033);
  }
  
  static int aQ(int paramInt1, int paramInt2)
  {
    int i = 3;
    if ((paramInt1 & 0x1) == 1)
    {
      paramInt1 = 7;
      return paramInt1;
    }
    if ((paramInt1 & 0x4) == 4) {
      return 6;
    }
    paramInt1 = i;
    switch (paramInt2)
    {
    case 0: 
    case 1: 
    case 12: 
    case 14: 
    case 16: 
    case 15: 
    default: 
      return 3;
    case 2: 
      return 0;
    case 13: 
      return 1;
    case 3: 
      return 8;
    case 4: 
      return 4;
    case 6: 
      return 2;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return 5;
    }
    return 10;
  }
  
  static String fb(int paramInt)
  {
    AppMethodBeat.i(193017);
    switch (paramInt)
    {
    case 15: 
    default: 
      String str = "unknown usage ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(193017);
      return str;
    case 0: 
      AppMethodBeat.o(193017);
      return "USAGE_UNKNOWN";
    case 1: 
      AppMethodBeat.o(193017);
      return "USAGE_MEDIA";
    case 2: 
      AppMethodBeat.o(193017);
      return "USAGE_VOICE_COMMUNICATION";
    case 3: 
      AppMethodBeat.o(193017);
      return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    case 4: 
      AppMethodBeat.o(193017);
      return "USAGE_ALARM";
    case 5: 
      AppMethodBeat.o(193017);
      return "USAGE_NOTIFICATION";
    case 6: 
      AppMethodBeat.o(193017);
      return "USAGE_NOTIFICATION_RINGTONE";
    case 7: 
      AppMethodBeat.o(193017);
      return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    case 8: 
      AppMethodBeat.o(193017);
      return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    case 9: 
      AppMethodBeat.o(193017);
      return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    case 10: 
      AppMethodBeat.o(193017);
      return "USAGE_NOTIFICATION_EVENT";
    case 11: 
      AppMethodBeat.o(193017);
      return "USAGE_ASSISTANCE_ACCESSIBILITY";
    case 12: 
      AppMethodBeat.o(193017);
      return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    case 13: 
      AppMethodBeat.o(193017);
      return "USAGE_ASSISTANCE_SONIFICATION";
    case 14: 
      AppMethodBeat.o(193017);
      return "USAGE_GAME";
    }
    AppMethodBeat.o(193017);
    return "USAGE_ASSISTANT";
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193061);
    if (!(paramObject instanceof AudioAttributesCompat))
    {
      AppMethodBeat.o(193061);
      return false;
    }
    paramObject = (AudioAttributesCompat)paramObject;
    if (this.bJr == null)
    {
      if (paramObject.bJr == null)
      {
        AppMethodBeat.o(193061);
        return true;
      }
      AppMethodBeat.o(193061);
      return false;
    }
    boolean bool = this.bJr.equals(paramObject.bJr);
    AppMethodBeat.o(193061);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(193039);
    int i = this.bJr.hashCode();
    AppMethodBeat.o(193039);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193049);
    String str = this.bJr.toString();
    AppMethodBeat.o(193049);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.media.AudioAttributesCompat
 * JD-Core Version:    0.7.0.1
 */