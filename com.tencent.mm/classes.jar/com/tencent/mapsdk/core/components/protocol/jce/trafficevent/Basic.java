package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Basic
  extends MapJceStruct
{
  public float anchor_x = 0.0F;
  public float anchor_y = 0.0F;
  public String brief = "";
  public int confidence = 0;
  public float coord_lat = 0.0F;
  public float coord_lon = 0.0F;
  public int end_time = 0;
  public String eventid = "";
  public String icon_highlight = "";
  public String icon_normal = "";
  public int max_scale = 0;
  public String message = "";
  public int min_scale = 0;
  public String roadname = "";
  public String source = "";
  public int start_time = 0;
  public int subtype = 0;
  public int type = 0;
  public int update_time = 0;
  
  public Basic() {}
  
  public Basic(String paramString1, String paramString2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, float paramFloat3, float paramFloat4, int paramInt7, int paramInt8)
  {
    this.eventid = paramString1;
    this.source = paramString2;
    this.type = paramInt1;
    this.subtype = paramInt2;
    this.coord_lat = paramFloat1;
    this.coord_lon = paramFloat2;
    this.brief = paramString3;
    this.message = paramString4;
    this.confidence = paramInt3;
    this.start_time = paramInt4;
    this.end_time = paramInt5;
    this.update_time = paramInt6;
    this.roadname = paramString5;
    this.icon_normal = paramString6;
    this.icon_highlight = paramString7;
    this.anchor_x = paramFloat3;
    this.anchor_y = paramFloat4;
    this.min_scale = paramInt7;
    this.max_scale = paramInt8;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221264);
    this.eventid = paramm.b(0, true);
    this.source = paramm.b(1, true);
    this.type = paramm.a(this.type, 2, true);
    this.subtype = paramm.a(this.subtype, 3, false);
    this.coord_lat = paramm.a(this.coord_lat, 4, false);
    this.coord_lon = paramm.a(this.coord_lon, 5, false);
    this.brief = paramm.b(6, false);
    this.message = paramm.b(7, false);
    this.confidence = paramm.a(this.confidence, 8, true);
    this.start_time = paramm.a(this.start_time, 9, false);
    this.end_time = paramm.a(this.end_time, 10, false);
    this.update_time = paramm.a(this.update_time, 11, false);
    this.roadname = paramm.b(12, false);
    this.icon_normal = paramm.b(13, true);
    this.icon_highlight = paramm.b(14, true);
    this.anchor_x = paramm.a(this.anchor_x, 15, true);
    this.anchor_y = paramm.a(this.anchor_y, 16, true);
    this.min_scale = paramm.a(this.min_scale, 17, true);
    this.max_scale = paramm.a(this.max_scale, 18, true);
    AppMethodBeat.o(221264);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221256);
    paramn.a(this.eventid, 0);
    paramn.a(this.source, 1);
    paramn.a(this.type, 2);
    paramn.a(this.subtype, 3);
    paramn.a(this.coord_lat, 4);
    paramn.a(this.coord_lon, 5);
    if (this.brief != null) {
      paramn.a(this.brief, 6);
    }
    if (this.message != null) {
      paramn.a(this.message, 7);
    }
    paramn.a(this.confidence, 8);
    paramn.a(this.start_time, 9);
    paramn.a(this.end_time, 10);
    paramn.a(this.update_time, 11);
    if (this.roadname != null) {
      paramn.a(this.roadname, 12);
    }
    paramn.a(this.icon_normal, 13);
    paramn.a(this.icon_highlight, 14);
    paramn.a(this.anchor_x, 15);
    paramn.a(this.anchor_y, 16);
    paramn.a(this.min_scale, 17);
    paramn.a(this.max_scale, 18);
    AppMethodBeat.o(221256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic
 * JD-Core Version:    0.7.0.1
 */