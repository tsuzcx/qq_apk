package com.tencent.map.lib.mapstructure;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jj;

public class TappedElement
{
  private static final int BUILDING_ID_LENGTH = 128;
  private static final int BUILDING_NAME_LENGTH = 68;
  private static final int FLOOR_NAME_LENGTH = 32;
  public static final int TYPE_ANNO = 1;
  public static final int TYPE_ANNO_INDOOR_MAP = 1;
  public static final int TYPE_BLOCKROUTE_ANNO = 7;
  public static final int TYPE_COMPASS = 3;
  public static final int TYPE_INDOORMAP_AREA = 8;
  public static final int TYPE_LINE = 5;
  public static final int TYPE_LOCATION_MARKER = 6;
  public static final int TYPE_NONE = 0;
  public String buildingId;
  public String buildingName;
  public String floorName;
  public long itemId;
  public int itemType;
  public String name;
  public int nameLen;
  public int pixelX;
  public int pixelY;
  public int type;
  
  public static TappedElement fromBytes(byte[] paramArrayOfByte)
  {
    int i = 20;
    AppMethodBeat.i(98164);
    TappedElement localTappedElement = new TappedElement();
    byte[] arrayOfByte1 = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 4);
    localTappedElement.type = jj.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 4, arrayOfByte1, 0, 4);
    localTappedElement.pixelX = jj.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 4);
    localTappedElement.pixelY = jj.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte1, 0, 4);
    localTappedElement.itemType = jj.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 16, arrayOfByte1, 0, 4);
    localTappedElement.nameLen = jj.a(arrayOfByte1);
    byte[] arrayOfByte2;
    if (localTappedElement.type != 7)
    {
      arrayOfByte2 = new byte[64];
      System.arraycopy(paramArrayOfByte, 20, arrayOfByte2, 0, 64);
      i = 84;
      if (localTappedElement.type == 8) {
        break label313;
      }
    }
    label313:
    for (localTappedElement.name = jj.d(arrayOfByte2);; localTappedElement.name = jj.a(arrayOfByte2, "UTF-8"))
    {
      System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
      int j = jj.a(arrayOfByte1);
      i += 4;
      System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
      localTappedElement.itemId = (jj.a(arrayOfByte1) + (j << 32));
      i += 4;
      if (localTappedElement.itemType == 1)
      {
        arrayOfByte1 = new byte[''];
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 128);
        i += 128;
        localTappedElement.buildingId = jj.a(arrayOfByte1, "UTF-8");
        arrayOfByte1 = new byte[68];
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 68);
        localTappedElement.buildingName = jj.d(arrayOfByte1);
        arrayOfByte1 = new byte[32];
        System.arraycopy(paramArrayOfByte, i + 68, arrayOfByte1, 0, 32);
        localTappedElement.floorName = jj.a(arrayOfByte1, "UTF-8");
      }
      AppMethodBeat.o(98164);
      return localTappedElement;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.mapstructure.TappedElement
 * JD-Core Version:    0.7.0.1
 */