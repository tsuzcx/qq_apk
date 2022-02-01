package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppEventsLogger$ProductAvailability
{
  static
  {
    AppMethodBeat.i(17360);
    IN_STOCK = new ProductAvailability("IN_STOCK", 0);
    OUT_OF_STOCK = new ProductAvailability("OUT_OF_STOCK", 1);
    PREORDER = new ProductAvailability("PREORDER", 2);
    AVALIABLE_FOR_ORDER = new ProductAvailability("AVALIABLE_FOR_ORDER", 3);
    DISCONTINUED = new ProductAvailability("DISCONTINUED", 4);
    $VALUES = new ProductAvailability[] { IN_STOCK, OUT_OF_STOCK, PREORDER, AVALIABLE_FOR_ORDER, DISCONTINUED };
    AppMethodBeat.o(17360);
  }
  
  private AppEventsLogger$ProductAvailability() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.ProductAvailability
 * JD-Core Version:    0.7.0.1
 */