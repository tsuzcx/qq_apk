package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c jgP;
  
  static
  {
    AppMethodBeat.i(135250);
    jgP = new c();
    AppMethodBeat.o(135250);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(135249);
    j.q(paramContext, "context");
    Object localObject = e.jgU;
    localObject = new File(e.ds(paramContext));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = e.jgU;
    localObject = new StringBuilder();
    e locale = e.jgU;
    e.p(paramContext, "dynamicBg/scene_shaderf.glsl", e.ds(paramContext) + "scene_shaderf.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/scene_shaderv.glsl", e.ds(paramContext) + "scene_shaderv.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/frag_framebuffer_plane.glsl", e.ds(paramContext) + "frag_framebuffer_plane.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/vertex_framebuffer_plane.glsl", e.ds(paramContext) + "vertex_framebuffer_plane.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/texture_vertex_shader.glsl", e.ds(paramContext) + "texture_vertex_shader.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/texture_fragment_shader.glsl", e.ds(paramContext) + "texture_fragment_shader.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/bg_gradient_vertex_shader.glsl", e.ds(paramContext) + "bg_gradient_vertex_shader.glsl");
    localObject = e.jgU;
    localObject = new StringBuilder();
    locale = e.jgU;
    e.p(paramContext, "dynamicBg/bg_gradient_fragment_shader.glsl", e.ds(paramContext) + "bg_gradient_fragment_shader.glsl");
    AppMethodBeat.o(135249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c
 * JD-Core Version:    0.7.0.1
 */